# Mysql技术内幕：InnoDB存储引擎

## InnoDB存储引擎

InnoDB存储引擎支持事务，其设计目标主要面向在线事务处理（OLTP）的应用。其特点是行锁设计、支持外键，并支持类似于Oracle的非锁定读，即默认读取操作不会产生锁。从MySQL数据库5.5.8版本开始，InnoDB存储引擎是默认的存储引擎。

InnoDB存储引擎将数据放在一个逻辑的表空间中，这个表空间就像黑盒一样由InnoDB存储引擎自身进行管理。从MySQL 4.1（包括4.1）版本开始，它可以将每个InnoDB存储引擎的表单独存放到一个独立的ibd文件中。此外，InnoDB存储引擎支持用裸设备（row disk）用来建立其表空间。

InnoDB通过使用多版本并发控制（MVCC）来获得高并发性，并且实现了SQL标准的4种隔离级别，默认为REPEATABLE级别。同时，使用一种被称为next-key locking的策略来避免幻读（phantom）现象的产生。除此之外，InnoDB储存引擎还提供了插入缓冲（insert buffer）、二次写（double write）、自适应哈希索引（adaptive hash index）、预读（read ahead）等高性能和高可用的功能。

对于表中数据的存储，InnoDB存储引擎采用了聚集（clustered）的方式，因此每张表的存储都是按主键的顺序进行存放。如果没有显式地在表定义时指定主键，InnoDB存储引擎会为每一行生成一个6字节的ROWID，并以此作为主键。



InnoDB存储引擎有多个一个由多个内存块组成的内存池，负责：

- 维护所有进程和线程需要访问的多个内部数据结构
- 缓存磁盘上的数据，方便快速读取，
- redo log缓冲

Master Thread是一个非常核心的后台线程，主要负责将缓冲池中的数据异步刷新到磁盘，保证数据的一致性，包括脏页的刷新、合并插入缓冲（INSERT BUFFER）、UNDO页的回收等



IO Thread 

在innodb存储引擎中大量使用AIO来处理写请求，而IO Thread主要负责这些AIO请求的回调处理，在Innodb中有四种Thread,分别是write,read,insert buffer,log io thread．



Purge Thread

用来回收已经使用并分配的undo页

Page Cleaner Thread 是将之前脏页的刷新操作放到单独的线程来执行，目的是为了减轻原Master　Thread的工作及对于用户查询线程的阻塞．

### 内存

１．缓存池

缓存池中缓存的数据页类型有：索引页，数据页，undo页，插入缓冲，自适应哈希索引，锁信息，数据字典信息等

数据库的缓冲池通过LRU算法来进行管理，在Innodb引擎中，LRU列表还加入了midpoint位置，新读取的页放到LRU列表的midpoint位置，通常在5/8处．把midpoint之后的列表称为old列表，之前的列表称为new列表，为什么不放在列表首部呢？因为某些SQL操作可能会使缓存池中的页被刷新出去，例如索引或数据的扫描操作．这类操作需要访问表中的许多页，甚至是全部页，而这些页并不是活跃的热点数据，如果将页放入到列表的首部，就会将真正需要的热点数据从LRU列表中移除，而在下一次需要读取该页的时候，Innodb存储引擎需要再次访问磁盘．当读入的页添加到LRU表的mid后，需要参数innodb_old_blocks_time来控制需要多久将该页添加到new列表，也就是LRU列表的热端．通过SHOW ENGINE INNODB STATUS;可以查看buffer pool hit rate 缓存池命中率，通常该值不应该小于95%。若发生Buffer pool hit rate的值小于95%这种情况，用户需要观察是否是由于全表扫描引起的LRU列表被污染的问题。

2.重做日志缓冲

innodb内存区域除了有缓冲池还有重做日志缓冲，innodb存储引擎将重做日志信息放入到这个缓冲区，按照一定的频率刷新到日志文件．

- Master Thread每一秒将重做日志缓冲刷新到重做日志文件；

- 每个事务提交时会将重做日志缓冲刷新到重做日志文件；

- 当重做日志缓冲池剩余空间小于1/2时，重做日志缓冲刷新到重做日志文件。

3.CheckPoint技术

所有页的操作都是先在缓冲池中完成的，例如updata，delete,insert等语句，此时的页是脏的，需要将其刷新到磁盘，但是不可能每变化一次就刷新一次，这样数据库性能会变得非常差，还有一种情况，如果刷新到磁盘时发生了宕机，就会导致数据的丢失，所以通常会先写重做日志，再修改页，如果发生数据丢失时，可以通过重做日志来恢复数据，这也是事务ACID中D(持久性)的要求．

由于缓冲池不可能缓存所有的数据，重做日志也不可能无限增大，所以需要定时进行将页刷新到磁盘．

检查点checkpoint解决以下问题：

- 缩短数据库的恢复时间－当数据库宕机时，不需要执行所有的重做日志，只需要执行上一次checkpoint到现在的日志
- 缓冲池不够用时，将脏页刷新到磁盘
- 重做日志不可用时，刷新脏页．

Sharp Checkpoint发生在数据库关闭时将所有的脏页都刷新回磁盘，这是默认的工作方式，即参数innodb_fast_shutdown=1。

Fuzzy Checkpoint进行页的刷新，即只刷新一部分脏页，而不是刷新所有的脏页回磁盘。



### Master Thread执行哪些动作

master thread是优先级最高的线程，主要由多个循环组成，包括主循环，后台循环，刷新循环，暂停循环．



innodb1.0版本之前：

主循环有两个操作，每１秒的操作和每10秒的操作

每秒执行下面的操作：

- 将重做日志缓冲中的内容刷新到重做日志文件，无论事务是否提交
- 如果前一秒内发生的IO次数小于５次，会执行合并插入缓冲的操作
- 判断当前缓冲池中的脏页比例是否超过配置文件中innodb_max_dirty_pages_pct这个参数（默认为90，代表90%），如果超过了这个阈值，InnoDB存储引擎认为需要做磁盘同步的操作，将100个脏页写入磁盘中。

接着来看每10秒的操作，包括如下内容：

❑刷新100个脏页到磁盘（可能的情况下）；

❑合并至多5个插入缓冲（总是）；

❑将日志缓冲刷新到磁盘（总是）；

❑删除无用的Undo页（总是）；

❑刷新100个或者10个脏页到磁盘（总是）。



若当前没有用户活动（数据库空闲时）或者数据库关闭（shutdown），就会切换到这个循环。background loop会执行以下操作：

❑删除无用的Undo页（总是）；

❑合并20个插入缓冲（总是）；

❑跳回到主循环（总是）；

❑不断刷新100个页直到符合条件（可能，跳转到flush loop中完成）。

InnoDB 1.2.x版本的Master Thread

其中srv_master_do_idle_tasks()就是之前版本中每10秒的操作，srv_master_do_active_tasks()处理的是之前每秒中的操作。同时对于刷新脏页的操作，从Master Thread线程分离到一个单独的Page Cleaner Thread，从而减轻了Master Thread的工作，同时进一步提高了系统的并发性。





### InnoDB关键特性

- 插入缓冲（Insert Buffer)
- 两次写（Double Write)
- 自适应哈希索引(Adaptive Hash Index)
- 异步IO
- 刷新邻接页







## Myisam存储引擎



MyISAM存储引擎不支持事务、表锁设计，支持全文索引，主要面向一些OLAP数据库应用。

MyISAM存储引擎的另一个与众不同的地方是它的缓冲池只缓存（cache）索引文件，而不缓冲数据文件，这点和大多数的数据库都非常不同。

MyISAM存储引擎表由MYD和MYI组成，MYD用来存放数据文件，MYI用来存放索引文件。可以通过使用myisampack工具来进一步压缩数据文件，因为myisampack工具使用赫夫曼（Huffman）编码静态算法来压缩数据，因此使用myisampack工具压缩后的表是只读的，当然用户也可以通过myisampack来解压数据文件。

对于MyISAM存储引擎表，MySQL数据库只缓存其索引文件，数据文件的缓存交由操作系统本身来完成，这与其他使用LRU算法缓存数据的大部分数据库大不相同。



## Memory存储引擎

Memory存储引擎（之前称HEAP存储引擎）将表中的数据存放在内存中，如果数据库重启或发生崩溃，表中的数据都将消失。它非常适合用于存储临时数据的临时表，以及数据仓库中的纬度表。Memory存储引擎默认使用哈希索引，而不是我们熟悉的B+树索引。

只支持表锁，并发性能较差，并且不支持TEXT和BLOB列类型。最重要的是，存储变长字段（varchar）时是按照定常字段（char）的方式进行的，因此会浪费内存

MySQL数据库使用Memory存储引擎作为临时表来存放查询的中间结果集（intermediate result）。如果中间结果集大于Memory存储引擎表的容量设置，又或者中间结果含有TEXT或BLOB列类型字段，则MySQL数据库会把其转换到MyISAM存储引擎表而存放到磁盘中。之前提到MyISAM不缓存数据文件，因此这时产生的临时表的性能对于查询会有损失。



## Maria存储引擎

Maria存储引擎的特点是：支持缓存数据和索引文件，应用了行锁设计，提供了MVCC功能，支持事务和非事务安全的选项，以及更好的BLOB字符类型的处理性能。















































