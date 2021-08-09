# 一、认识Linux

1.linux应用领域

- 1.linux服务器
- 2.嵌入式linux系统
- 3.软件开发平台
- 4.桌面应用

2.linux系统特点

- 1.开放性
- 2.多用户
- 3.多任务
- 4.良好的用户界面
- 5.设备独立性
- 6.丰富的网络功能
- 7.可靠地系统安全
- 8.良好的可移植性

3.linux系统的组成

- 1.内核

  虚拟内存,多任务,共享库,需求加载,可执行程序和TCP/IP网络功能

  主要模块:存储管理,CPU和进程管理,文件系统,设备管理和驱动,网络通信,系统的初始化和系统调用.

- 2.Shell

  命令解释器,将用户输入命令传到内核

- 3.文件系统

  xfs,ext4,ext3,ext2,msdos,vfat,iso9660

- 4.应用程序

4.linux版本

- 内核版本

  内核版本是linux内核在历次修改或增加相应功能后的版本编号，内核是一个用来和硬件打交道并为用户程序提供有限服务集的支撑软件，是操作系统中最核心的功能框架部分。

- 发行版本

  red hat,suse,oracle,centos,ubuntu,debian,mandriva,gentoo,slackware,fedora



# 二、linux系统硬件要求

- cpu 
- 内存：至少1G
- 硬盘10G
- 显示器和显卡
- DVD光驱

5.交换分区

- 用作虚拟内存的磁盘空间被称为交换分区(swap分区),内核将暂时不用的内存块信息写到交换分区,需要时再重新载入
- linux的内存管理采用的是分页存取机制
- linux系统会不时的进行页面交换操作,以保持尽可能多的内存
- linux内核根据最近最常使用算法,仅仅将一些不经常使用的页面文件交换到虚拟内存

6.分区命名/dev/xxyN

- /dev:所有设备文件所在目录名
- xx:分区所在的设备类型,hd(IDE硬盘),sd(SCSI硬盘)
- y:分区所在设备,/Dev/hda(第一个IDE硬盘)
- N:代表分区,前四个分区是主分区和扩展分区用1-4表示,逻辑驱动器从5开始

7.分区和挂载目录

- 挂载:将分区关联到某一目录的过程,挂载分区使起始于这个指定目录(挂载目录)的存储区能够被使用.

8.分区规划

- swap:交换分区
- boot:用来存放与linux系统启动有关的程序,比如引导装载程序
- /usr分区:存放linux系统中的应用程序
- /var分区:存放Linux系统中经常变化的数据以及日志文件
- /分区:linux系统根目录,所有目录都挂载这个目录下
- /home分区:存放普通用户的数据,是普通用户的宿主目录

# 三、FirewallD防火墙

在RHEL 7系统中默认使用FirewallD防火墙，FirewallD提供了支持网络/防火墙区域定义网络链接以及接口安全等级的动态防火墙管理工具

它支持IPv4、IPv6防火墙设置以及以太网桥接，并且拥有运行时配置和永久配置选项。

FirewallD可以动态管理防火墙，支持动态配置，不用重启服务

默认情况下FirewallD防火墙的连接区域为public，public在公共区域内使用，指定外部连接可以进入内部网络或主机

要进入Linux系统的字符界面可以通过字符界面、图形界面下的终端以及虚拟控制台等多种方式进入。

9.shutdown命令

- shutdown [选项] [时间] [警告信息]
- shutdown -h now #立即关闭
- shutdown -h +45 #45分钟后关闭
- shutdown -r now "note" #发出警告
- shutdown -r 08:20

10.halt:

- halt就是调用shutdown -h命令

11.reboot

- 重启计算机

12.man和help

- man ls
- ls --help

13.shell

- 主要作用的侦听用户指令,启动指令所指定的进程并将结果返回给用户
- shell命令重新初始化用户的登录会话,当给出该命令时,就会重新设置进程的控制终端的端口特征,并取消对端口的所有访问
- 目前流行的shell有sh,csh,ksh,tcsh,bash

14.bash

- bash的命令语法很多来自ksh和csh,比如命令行编译,命令历史,目录栈,#random,$ppid变量

15.常用控制组合键

- Ctrl+l 清屏
- Ctrl+o 执行当前命令，并选择上一条命令
- Ctrl+s 阻止屏幕输出
- Ctrl+q 允许屏幕输出
- Ctrl+c 终止命令
- Ctrl+z 挂起命令
- Ctrl+m 相当于按回车键
- Ctrl+d 输入结束，即EOF的意思，或者注销Linux
- Ctrl+a 移动光标到命令行首
- Ctrl+e 移动光标到命令行尾
- Ctrl+f 按字符前移（向右）
- Ctrl+b 按字符后移（向左）
- Ctrl+xx 在命令行首和光标之间移动
- Ctrl+u 删除从光标到命令行首的部分
- Ctrl+k 删除从光标到命令行尾的部分
- Ctrl+w 删除从光标到当前单词开头的部分
- Ctrl+d 删除光标处的字符
- Ctrl+h 删除光标前的一个
- Ctrl+y 插入最近删除的单词
- Ctrl+t 交换光标处字符和光标前面的字符
- Alt+f 按单词前移（向右）
- Alt+b 按单词后移（向左）
- Alt+d 从光标处删除至单词尾
- Alt+c 从光标处更改单词为首字母大写
- Alt+u 从光标处更改单词为全部大写
- Alt+l 从光标处更改单词为全部小写
- Alt+t 交换光标处单词和光标前面的单词
- Alt+Backspace 与Ctrl+w功能类似，分隔符有些

使用命令历史记录功能键。
[root@rhel ~]# mkdir /root/aaa
//创建目录/root/aaa
[root@rhel ~]# cd !$
cd /root/aaa
//!$是指重复前一个命令最后的参数，参数是/root/aaa
[root@rhel aaa]# pwd
/root/aaa
//显示用户当前目录是/root/aaa

- Ctrl+p 查看历史列表中的上一个命令
- Ctrl+n 查看历史列表中的下一个命令
- Ctrl+r 向上搜索历史列表
- Alt+p 向上搜索历史列表
- Alt+> 移动到历史列表
- 命令语法：
  alias [别名]＝[需要定义别名的命令] 
  2．取消别名
  当用户需要取消别名的定义时，可以使用unalias命令。
  命令语法：
  unalias [别名] 

RHEL 7使用目标target）替换运行级别。目标使用目标单元文件描述，目标单位文件扩展名是.target，目标单元文件的唯一目标是将其他systemd单元文件通过一连串的依赖关系组织在一起。

每一个目标都有名字和独特的功能，并且能够同时启用多个。一些目标继承其他目标的服务，并启动新服务

重定向有四种方式：输出重定向、输入重定向、错误重定向以及同时实现输出和错误的重定向

输出重定向，即将某一命令执行的输出保存到文件中，如果已经存在相同的文件，那么覆盖源文件中的内容。
命令语法：[命令] > [文件]

另外一种特殊的输出重定向是输出追加重定向，即将某一命令执行的输出添加到已经存在的文件中。
命令语法：[命令] >> [文件]

输入重定向，即将某一文件的内容作为命令的输入。
命令语法：[命令] < [文件]

错误重定向，即将某一命令执行的出错信息输出到指定文件中。
命令语法：[命令] 2> [文件]

另外一种特殊的错误重定向是错误追加重定向，即将某一命令执行的出错信息添加到已经存在的文件中。
命令语法：[命令] 2>> [文件]

同时实现输出和错误的重定向，即可以同时实现输出重定向和错误重定向的功能。
命令语法：[命令] &> [文件]

vi编辑器有3种基本工作模式，分别是命令模式、插入模式和末行模式。

- i 从光标当前所在位置之前开始插入
- a 从光标当前所在位置之后开始插入
- I 在光标所在行的行首插入
- A 在光标所在行的行末尾插入
- o 在光标所在的行的下面新开一行插入
- O 在光标所在的行的上面新开一行插入
- s 删除光标位置的一个字符，然后进入插入模式
- S 删除光标所在的行，然后进入插入

- k 使光标向上移动一行
- j 使光标向下移动一行
- h 使光标向左移动一个字符
- l 使光标向右移动一个字符
- nk 使光标向上移动n行，n代表数字
- nj 使光标向下移动n行，n代表数字
- nh 使光标向左移动n个字符，n代表数字
- nl 使光标向右移动n个字符，n代表数字
- H 使光标移动到屏幕的顶部
- M 使光标移动到屏幕的中间
- L 使光标移动到屏幕的底部
- Ctrl+b 使光标往上移动一页屏幕
- Ctrl+f 使光标往下移动一页屏幕
- Ctrl+u 使光标往上移动半页屏幕
- Ctrl+d 使光标往下移动半页屏幕
- （数字0） 使光标移到所在行的行首
- $ 使光标移动到光标所在行的行尾
- ^ 使光标移动到光标所在行的行首
- w 使光标跳到下一个字的开头
- W 使光标跳到下一个字的开头，但会忽略一些标点符号
- e 使光标跳到下一个字的字尾
- E 使光标跳到下一个字的字尾，但会忽略一些标点符号
- b 使光标回到上一个字的开头
- B 使光标回到上一个字的开头，但会忽略一些标点符号
- ( 使光标移动到上一个句首
- ) 使光标移动到下一个句首
- { 使光标移动到上一个段落首
- } 使光标移动到下一个段落首
- G 使光标移动到文件尾（最后一行的第一个非空白字符处）
- gg 使光标移动到文件首（第一行第一个非空白字符

# 四、文件

Linux文件类型常见的有：普通文件、目录文件、设备文件（字符设备文件和块设备文件）、管道文件和符号链接文件等。

ls -lh查看

- -rw-------:普通文件

- “drwxr-xr-x:目录文件

- Linux系统中的/dev目录中有大量的设备文件，主要是块设备文件和字符设备文件。

  - 块设备文件 :/dev/sda1,brw-rw----
  - 字符设备文件:/dev/null:送入这个设备的所有内容都被忽略。crw--w----

- 管道文件:FIFO文件,管道文件就是从一头流入，从另一头流出.prw------;

- 链接文件有两种类型：软链接文件和硬链接文件。

  - 软链接文件又叫符号链接文件，这个文件包含了另一个文件的路径名。lrwxrwxrwx

    在对软链接文件进行读写的时候，系统会自动地把该操作转换为对源文件的操作，但删除软链接文件时，系统仅仅删除软链接文件，而不删除源文件本身。ln -s 源文件名称 软链接文件名称

  - 硬链接是已存在文件的另一个文件，对硬链接文件进行读写和删除操作时，结果和软链接相同。但如果删除硬链接文件的源文件，硬链接文件仍然存在，而且保留了原有的内容。ln  源文件名称 硬链接文件名称

# 五、目录结构

- /home 包含Linux系统上各用户的主目录，子目录名称默认以该用户名命名
- /root 是root用户的主目录
- /bin 包含常用的命令文件，不能包含子目录
- /sbin 包含系统管理员和root用户所使用的命令文件
- /dev 包含大部分的设备文件，比如磁盘、光驱等
- /lib 包含Linux系统的共享文件和内核模块文件
- /lib/modules目录存放核心可加载模块
- /lib64 包含64位版本Linux系统的共享文件和内核模块文件
- /tmp 包含一些临时文件
- /mnt 手动为某些设备（比如硬盘）挂载提供挂载
- /boot 包含Linux系统的内核文件和引导装载程序（如GRUB）文件
- /opt 包含某些第三方应用程序的安装文件
- /media 由系统自动为某些设备（一般为光盘、U盘等设备）挂载提供挂载目录
- /var 该目录存放经常变化的数据，如系统日志、打印队列、DNS数据库文件等
- /etc 包含Linux系统上大部分的配置文件，建议修改配置文件之前先备份
- /usr 包含可以供所有用户使用的程序和数据
- /srv 存储一些服务启动之后所需要取用的资料目录
- /run 一个临时文件系统，一些程序或服务启动以后，会将他们的PID放置在该目录中
- /sys 在Linux系统提供热插拔能力的同时，该目录包含所检测到的硬件设置，它们被转换成/dev目录中的设备文件
- /proc是一个虚拟的文件系统，它不存在磁盘上，而是由内核在内存中产生，用于提供系统的相关信息。下面说明在/proc目录下的一些最重要的文件。/proc/cpuinfo：该文件保存计算机CPU信息。/proc/filesystems：该文件保存Linux文件系统信息。/proc/ioports：该文件保存计算机I/O端口号信息。/proc/version：该文件保存Linux系统版本信息。/proc/meminfo：该文件保存计算机内存信



涉及的命令有pwd、cd、ls、touch、mkdir、rmdir、cp、mv、rm、wc等

touch:创建文件

wc是统计指定文件中的字节数（-c），字数(-w)，行数(-l)

硬链接文件有两个限制：
 （1）不允许给目录创建硬链接；
 （2）只有在同一文件系统中的文件之间才能创建链接

软链接也叫符号链接，这个文件包含了另一个文件的路径名。可以是任意文件或目录，可以链接不同文件系统的文件，和Windows下的快捷方式相似。链接文件甚至可以链接不存在的文件，这就产生一般
称之为“断链”的问题，链接文件甚至可以循环链接自己



### 5.1文本内容显示

cat,more,less,head,tail

- cat /etc/1.text
- cat -n text1 > text2 #加上行号输入2
- cat >mm.txt<<EOF //在此输入字符EOF，会自动回到shell提示符界面
- more  /etc/services
-  more -s testfile //逐页显示testfile文件内容，如有连续两行以上空白行则以一行空白行显示
- more +20 testfile //从第20行开始显示testfile文件的内容。
-  more -2 /etc/passwd   //  一次两行显示/etc/passwd文件内容。
- less :回卷显示文本文件
- head:显示指定文件前若干行,默认为10行
-  head –c 100 /etc/passwd //查看前100个字节
-  head -3 /etc/passwd //查看前3行
- tail:查看文件末尾数据

### 5.2文本内容处理

sort,uniq,cut,comm,diff

- sort:对文件中的数据进行排序,并将结果显示在标准输出上
- sort text1
- sort -r text //倒序排序
- uniq:将重复行从输出文件中删除
- uniq -d text1 //查看文件中重复的内容
- uniq -u text1 //查看不重复的数据内容
- cut 从文件每行中显示出选定的字节,字符或字段
-  cut -f 1,5 -d: /etc/passwd //显示文件/etc/passwd中的用户登录名和用户名全称字段，这是第1个和第5个字段，由冒号隔开。
- comm 逐行比较两个已排过序的文件
-  comm -12 file1 file2 //比较文件file1和file2，只显示文件file1和file2中相同行的数据内容
- diff:逐行比较两个文件,列出其不同之处

### 5.3 文件和命令查找

grep,find,locate

- grep :查找文件中符合条件的字符串
- grep 选项 查找模式 文件名
- grep 'test file' kkk //在文件kkk中搜索匹配字符“test file”。
-  grep 'test' d* //显示所有以d开头的文件中包含“test”的行数据内容
- grep ^b /root/aa //在/root/aa文件中找出以b开头的行内容。
-  grep -v ^b /root/aa  //在/root/aa文件中找出不是以b开头的行内容
- grep le$ /root/kkk  //在/root/kkk文件中找出以le结尾的行内容
-  ps –ef|grep sshd  //查找sshd进程信息。
- find：列出文件系统内符合条件的文件可以指定文件的名称、类别、时间、大小以及权限等不同信息的组合
-  find /boot -name grub.cfg//查找/boot目录下的启动菜单配置文件grub.cfg。
-  find / -name '*.conf‘  //查找/目录下所有以“.conf”为扩展名的文件
-  find . -ctime -20 //列出当前目录及其子目录下所有最近20天内更改过的文件
- locate：在数据库中查找文件
-  locate httpd.conf //查找httpd.conf文件。
-  locate -c httpd.conf //显示找到几个httpd.conf文件 。

### 5.4系统信息显示

uname,hostname,free,du

- uname:显示计算机及操作系统相关信息
- uname -r //显示操作系统的内核发行号
- uname -m //显示计算机硬件架构名称
- uname -a//显示操作系统的全部信息
- hostname:显示或修改计算机主机名
-  hostname LINUX //修改计算机主机名为LINUX。
- free：查看内存信息 ,显示系统的物理内存和swap的使用情况
- free -m //以MB为单位查看系统的物理内存和交换分区使用情况。
- free -t //显示系统的物理内存加上交换分区总的容量。
- du:显示目录或文件的磁盘占用量
- du [选项] [文件|目录]
- du /etc/inittab  //显示文件/etc/inittab的磁盘占用量。
- du –s /root //显示/root目录磁盘占用量.
-  du –sh /root //以MB为单位显示/root目录磁盘占用量。

### 5.5日期和时间

cal,date,hwclock

- cal:显示日历信息
- cal 2001 //显示公元2001年年历
- cal 9 2010
- cal -m //以星期一为每周的第一天的方式显示本月的日历。
- cal -jy //以1月1日起的天数显示今年的年历
- date：显示和设置系统日期和时间
-  date +'%r%a%d%h%y'  //按照指定的格式显示计算机日期和时间
- date -s 09:16:00 //设置计算机时间为上午9点16分
- date -s 240414 //设置计算机时间为2024年4月14日
- hwclock：查看和设置硬件时钟
- hwclock -w 以系统时间更新 硬件时间
- hwclock -s //以硬件时间更新系统时间

### 5.6信息交流

echo,mesg,wall,write

- mesg：允许或拒绝写消息

- wall：对全部已登录用户发送信息

- write：向用户发送消息

- clear：清除计算机屏幕信息

- uptime：显示系统已经运行

  ​																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																															

# 六、Shell程序

- shell程序就是放在一个文件中的一系列linux命令和实用程序
- #!/bin/bash
- chmod u+x /text
- HOME 用于保存用户主目录的完全路径名
  PATH
  用于保存用冒号分隔的目录路径名，Shell将按PATH变量中给出的顺序
  搜索这些目录，找到的第一个与命令名称一致的可执行文件将被执行
  TERM 终端的类型
  UID 当前用户的UID，由数字构成
  PWD 当前工作目录的绝对路径名，该变量的取值随cd命令的使用而变化
  PS1 
  主提示符，在root用户下，默认的主提示符是“#”，在普通用户下，默
  认的主提示符是“$”
  PS2
  在Shell接收用户输入命令的过程中，如果用户在输入行的末尾输入“\”
  然后按回车键，或者当用户按回车键时Shell判断出用户输入的命令没
  有结束时，就显示这个辅助提示符，提示用户继续输入命令的其余部
  分，默认的辅助提示符是“>
- 使用export说明的变量在Shell以后运行的所有命令或程序中都可以访问到。
- Shell取第一个位置参数替换程序文件中的$1，第二个替换$2，依次类推。$0是一个特殊的变量，它的内容是当前这个Shell程序的文件名，所以$0不是一个位置参数，在显示当前所有的位置参数时是不包括$0的

#### 预定义变量

- $# 位置参数的数量
- $* 所有位置参数的内容
- $? 命令执行后返回的状态，0表示没有错误，非0表示有错误
- $$ 当前进程的进程号
- $! 后台运行的最后一个进程号
- $0 当前执行的进程名

#### 参数置换的变量

- 变量=${参数-word} //如果参数设置了则变量为参数,参数没有设置则为word
- 变量=${参数=word}//如果参数没有设置,变量设为word,参数也为word
- 变量=${参数?word} //如果设置了参数，则用参数的值置换变量的值，否则就显示word并从shell中退出，
- 变量=${参数+word} //如果设置了参数，则用word置换变量，否则不进行置换

#### 变量比较



- -n //比较字符串的长度是否大于0,如果大于0则为是
- -z //比较字符串的场地是否等于0,如果等于0为是

#### 数字比较

0表示是

- -eq //相等
- -ge :大于等于
- -le :小于等于
- -ne:不等于
- -gt:大于
- -lt:小于

#### 逻辑测试

! 与一个逻辑值相反的逻辑值

-a 两个逻辑值为“是”返回值才为“是”，反之为“否” and

-o 两个逻辑值有一个为“是”，返回值就为是  or

#### 文件操作测试符

- -d 对象存在且为目录则返回值为“是”
- -f 对象存在且为文件则返回值为“是”
- -L 对象存在且为符号链接则返回值为“是”
- -r 对象存在且可读，则返回值为“是”
- -s 对象存在且长度非0则返回值为“是”
- -w 对象存在且可写，则返回值为“是”
- -x 对象存在且可执行，则返回值为“是”
- ! 测试条件的否定

# 七、用户账户管理

与用户和组账户相关的配置文件有/etc/passwd、/etc/shadow、/etc/group和/etc/gshadow。

用户的角色是通过UID（用户ID号）来标识的，每个用户的UID都是不同的

分别是root用户

- UID为0

系统用户

- 这类用户不具有登录Linux系统的能力，这类用户都是系统自身拥有的。系统用户的UID为1~999

普通用户

- 这类用户都是系统管理员创建的。普通用户的UID为1000~60000

/etc/passwd文件是系统识别用户的一个重要文件，Linux系统中所有的用户都记录在该文件中。

UID是确认用户权限的标识，用户登录系统所处的角色是通过UID来实现的，而不是用户名

/etc/shadow文件是/etc/passwd的影子文件，这个文件并不是由/etc/passwd文件产生，这两个文件应该是对应互补的。/etc/shadow文件内容包括用户及被加密的密码以及其它/etc/passwd不能包括的信息，比如用户账户的有效期限等。

创建用户：

- 创建用户账户zhangsan并设置密码。useradd zhangsan
- cat /etc/passwd | grep zhangsan
- passwd zhangsan
- 创建用户moon，并设置该用户UID为1510。useradd -u 1010 moon
- 创建用户newuser，并设置该用户主目录为/home/www: useradd -d /home/www newuser
- 创建用户pp，并指定该用户是属于组群root的成员:useradd -g root pp    // id pp查看组群

修改用户

- 修改用户zhangsan的主目录为/home/kkk，并手动创建/home/kkk目录。
-  usermod -d /home/kkk zhangsan
- mkdir /home/kkk
- usermod -d /home/opop -m zhangsan
- 修改用户wangwu的登录名为zhaoliu。
-  usermod -l zhaoliu wangwu
- 修改用户zhangsan的用户名全称为张三。
-  usermod -c 张三 zhangsan, cat /etc/passwd|grep zhangsan
- 修改用户sun所属的组群为root，该组群必须事先存在。usermod -g root sun
- 锁住用户zhangsan密码，使密码无效。usermod -L zhangsan
-  usermod -U zhangsan 解除锁
- 删除用户lisi：userdel lisi
- 删除用户moon，并且在删除该用户的同时一起删除主目录。 userdel -r moon

组群

创建组群：

- groupadd china
- 创建名为ou的组群，并且设置该组群GID为1800。 groupadd -g 1800 ou
- 创建名为chinese的系统组群：groupadd -r chinese
- 将组群ou的GID修改为1900。 groupmod -g 1900 ou
- 修改组群ou的新组群名称为shanghai： groupmod -n shanghai ou
- 删除组群shanghai。：groupdel shanghai



查看用户ab是属于哪些组群的成员。groups ab





# 八、磁盘管理

磁盘分区是指对硬盘物理介质的逻辑划分。将磁盘分成多个分区，不仅仅利于对文件的管理，而且不同的分区可以建立不同的文件系统，这样才能在不同的分区上安装不同的操作系统

磁盘分区一共有3种：主分区、扩展分区和逻辑驱动器

在一块磁盘上最多只能有四个主分区，可以另外建立一个扩展分区来代替四个主分区的其中一个，然后在扩展分区下可以建立更多的逻辑驱动器

在Linux系统中进行分区可以使用fdisk和parted等命令

格式化是指对磁盘分区进行初始化的一种操作，格式化是在磁盘中建立磁道和扇区，建立好之后，计算机才可以使用磁盘来储存数据。使用mkfs命令

使用fdisk命令可以用来对磁盘进行分区，用来查看磁盘分区的详细信息，

子命令 功能

- m 显示所有能在fdisk中使用的子命令，more
- p 显示磁盘分区信息,part
- a 设置磁盘启动分区,
- n 创建新的分区,new
- e 创建扩展分区,extends
- p 创建主分区,
- t 更改分区的系统ID（也就是分区类型ID）
- d 删除磁盘分区,delete
- q 退出fdisk，不保存磁盘分区设置,quit
- l 列出已知的分区类型,list
- v 验证分区表,view
- w 保存磁盘分区设置并退出fdisk,write

步骤：

- 进入fdisk界面，显示磁盘分区信息。
- 创建和删除主分区。
- 创建扩展分区和逻辑驱动器。
- 查看并转换分区类型。
- 保存分区设置信息，并退出fdisk
-  在非交互式界面下显示当前硬盘的分区信息。
-  查看分区情况（使用partprobe命令更新分区表，使内核识别分区 

首先需要确认文件系统的类型，然后才能挂载使用，通过mount加载或者通过修改/etc/fstab文件开机自动加载都可以实现该功能。

文件系统是指文件在硬盘上的存储方法和排列顺序：有XFS、ext4、JFS、ReiserFS、ext2、
ext3、ISO9660、MSDOS，VFAT、NFS

使用mkfs命令可以在分区上创建各种文件系统。

使用mkfs命令创建文件系统。

- ）查看当前磁盘上的分区情况，该磁盘设备是/dev/sda。fdisk -l /dev/sda
-  ls /dev/sda*
-  mkfs -t ext4 /dev/sda5      //创建磁盘分区

通过使用mount和umount命令可以实现文件系统的挂载和卸载

mount [选项] [设备] [挂载目录]

挂载分区/dev/sda5到/mnt/kk目录中。

-  mkdir /mnt/kk
- mount /dev/sda5 /mnt/kk    //mount -o ro  /dev/sda5 /mnt/kk    是只读
-  ls /mnt/kk
- touch /mnt/kk/abc
-  ls /mnt/kk
-  df //查看磁盘分区挂载的详细信息
- 卸载分区/dev/sda5文件系统。umount /dev/sda5

开机自动挂载文件系统：通过修改/etc/fstab文件实现开机自动挂载文件系统：

- 设备   挂载目录   文件系统类型   挂载选项   转储选项   文件系统检查选项
- /dev/sda5     /mnt/www     xfs    defaults    1    2
- 先使用以下命令查看磁盘分区/dev/sda5的UUID信息。： ls –l /dev/disk/by-uuid
- 然后编辑/etc/fstab文件，在该文件末尾添加下列内容。
  UUID= f084b8a6-c9ab-425b-99da-b64cb35e4fc2
  /mnt/www xfs defaults 1 2

添加交换分区：

- 创建磁盘分区 查看： fdisk -l /dev/sda
- 创建交换分区： mkswap /dev/sda5  //将/dev/sda5分区创建为交换
- 启用交换分区：swapon /dev/sda5
- free
- 确认已经启用交换分区: cat /proc/swaps 
- 编辑/etc/fstab文件

 磁盘分区是指对硬盘介质的逻辑划分，格式化是指对磁盘分区进行初始化的一种操作，把一张空白的磁盘划分成一个个小区域编号，供计算机存储和读取数据，格式化是在磁盘中建立磁道和扇区，建立好之后，计算机才可以使用磁盘来储存数据。



# 九、 RPM

#### RPM软件包管理

1.用途：

- 可以安装、删除、升级、刷新和管理rpm软件包
- 知道软件包包含哪些文件
- 查询rpm软件包是否安装
- 把自己的程序打包成rpm发布
- 依赖性检查

2.操作模式：安装、删除、刷新、升级、查询

- 安装：rpm -ivh rpm包名    // rpm -ivh --replacepkgs//重新安装

- 删除： rpm -e 包名

- 升级：rpm -Uvh 包名 //如果没有安装，则会安装

- 刷新： rpm -Fvh 包名 //如果没有被安装，则不会安装

- 查询

  - 查询是否安装：rpm -q 软件包

  - 查询所有安装过的： rpm -qa // rpm –qa |grep cront//结合管道查询

  - 查询已安装包的描述信息： rpm -qi 包名

  - 查询指定已安装RPM软件包所包含的文件列表： rpm -ql 包名

  - 查询RPM软件包的依赖关系：rpm -qR 包名

  - 查询系统中指定文件属于哪个RPM软件包：rpm -qf,

    

yum :其宗旨是自动化地升级、安装和删除RPM软件包，收集RPM软件包的相关信息，检查依赖性并且一次安装所有依赖的软件包，无须繁琐地一次次安装 

yum特点：

- 可以同时配置多个软件仓库
- 简洁的配置文件/etc/yum.conf
- 自动解决安装或者删除rpm软件包时遇到的依赖性问题
- 使用方便
- 保持与rpm数据库的一致性

软件仓库配置文件默认存储在/etc/yum.repos.d目录中。

yum语法：

- yum help
- yum list //列出软件包
- yum serch keyword//搜索关键字
- yum info packagename //列出软件包详细信息
- yum install packagename //安装软件包
- yum remove packagename//删除软件包
- yum update packagename //升级软件包
- 显示所有已经安装的软件包信息。
  [root@rhel ~]# yum info installed
- 列出bind软件包。
  [root@rhel ~]# yum list bind 
- 列出bind软件包的依赖关系。
  [root@rhel ~]# yum deplist bind 
- 显示软件仓库的配置。
  [root@rhel ~]# yum repolist

使用yum命令安装软件包组

- 1.yum grouplist 列出所有可用组
  2.yum groupinfo 提供特定组的信息
  3.yum groupinstall 安装软件包组
  4.yum groupupdate 更新软件包组
  5.yum grouperase 删除软件包组

使用yum命令安装本地rpm包

- yum localinstall *.rpm 

使用tar命令可以将文件和目录进行打包或压缩以做备份用。

- 备份/root/abc目录及其子目录下的全部文件，备份文件名为abc.tar。：tar cvf abc.tar /root/abc
- 查看abc.tar备份文件的内容，并显示在显示器上：tar tvf abc.tar
- 将打包文件abc.tar解包出来。:tar xvf abc.tar
- 将文件/root/abc/d添加到abc.tar包里面去:touch /root/abc/d   && tar rvf abc.tar /root/abc/d
- 更新原来tar包abc.tar中的文件/root/abc/d: tar uvf abc.tar /root/abc/d
- 把/root/abc目录包括其子目录全部做备份文件，并进行压缩，文件名为abc.tar.gz。
   tar zcvf abc.tar.gz /root/abc
- 查看压缩文件abc.tar.gz的内容，并显示在显示器上。
  tar ztvf abc.tar.gz
- 将压缩文件abc.tar.gz解压缩出来: tar zxvf abc.tar.gz
- 

# 十、权限和所有者

### 权限设置

- 文件的用户所有者（属主）、文件的组群所有者（用户所在组的同组用户）、系统中的其它用户,构成了一个有九种类型的权限组。
- 一个文件和目录可能有读取、写入及执行权限。
- r(读取,浏览),w(写入,删除移动),x(执行,进入) //(文件,目录)
- -rwx------ ,第一个-代表是文件,后面分别是用户所有者,组内用户,其他用户
- drwx--x--x,第一个d表示是目录
- ls –l 命令可以显示文件的详细信息，其中包括权限，
- chmod [操作对象] [操作符号] [权限] [文件|目录] 
  - 操作对象,u表示用户所有者,g表示组,o表示其他用户,a表示所有
  - 操作符,+ 添加权限,-取消权限,=赋予给定权限
- 数字表示权限
- 0表示没有权限，1表示可执行权限，2表示写入权限，4表示读取权限，然后将其相加。
- [root@rhel ~]# mkdir /home/user
- [root@rhel ~]# touch /home/user/abc
- [root@rhel ~]# chmod -R 777 /home/us
- touch命令是创建文件的
- 

### 更改文件和目录所有者

chown [选项] [用户.组群] [文件|目录]
chown [选项] [用户:组群] [文件|目录]

- 将文件a的所有者改成newuser
- chown newuser a
- 将文件a的用户组改成newuser。
- chown :newuser a
- 将目录/root/b连同它的下级文件/root/b/ccc的所有者和用户组一起更改为newuser。
-  chown -R newuser.newuser /root/b





# 十一、 linux日常管理和维护

## 进程管理

Linux系统上所有运行的内容都可以称为进程。每个用户任务、每个系统管理守护进程都可以称为进程。

Linux系统用分时管理方法使所有的任务共同分享系统资源。

- 进程是在自身的虚拟地址空间运行的一个单独的程序。
- 进程与程序之间还是有明显区别的。程序只是一个静态的命令集合，不占系统的运行资源；而进程是一个随时都可能发生变化的、动态的、使用系统运行资源的程序。
- 一个程序可以启动多个进程。
- 和进程相比较，作业是一系列按一定顺序执行的命令。一条简单的命令可能会涉及多个进程，尤其是当使用管道和重定向时。

进程的特征

- 动态性:进程的实质是程序在多道程序系统中的一次执行过程,进程是动态产生,动态消亡的
- 并发性:任何进程都可以同其他进程一起并发执行
- 独立性:进程是一个能独立运行的基本单位,同时也是系统分配资源和调度的独立单位
- 异步性:由于进程间的相互制约，使得进程具有执行的间断性，即进程按各自独立的、不可预知的速度向前推进。
- 结构特性:进程由程序、数据和进程控制块三部分组成。
- 多个不同的进程可以包含相同的程序：一个程序在不同的数据集里就构成不同的进程，能得到不同的结果；但是执行过程中，程序不能发生改变。

进程种类

- 交互式进程:由shell启动并控制的进程
- 批处理进程:与终端无关,安排在指定时刻完成的一系列进程
- 守护进程:在引导系统时,以执行即时的操作系统任务

ps命令是最基本同时也是非常强大的进程查看命令。使用该命令可以确定有哪些进程正在运行以及进程运行的状态、进程是否结束、进程有没有僵死，以及哪些进程占用了过多的资源等。

- 显示所有进程 ps -e
- 显示所有不带控制台终端的进程，并显示用户名和进程的起始时间。ps -aux
- 查看less进程是否正在运行 ps -ax| grep less
- 显示用户名和进程的起始时间 ps -u
- 显示用户root的进程 ps -u root
- 显示tty1终端下的进程 ps -t tty1
- 显示进程号为1659的进程  ps -p 1659

使用top命令可以显示当前正在运行的进程以及关于它们的重要信息，包括它们的内存和CPU使用量。

- 强制杀死进程号为1659的进程
-  ps –ef|grep crond //查询到crond进程号为1659
- kill –9 1659
- 

## 任务计划

如果要在固定的时间上触发某个作业，就需要创建任务计划，按时执行该作业，在Linux系统中常用cron实现该功能

使用cron实现任务自动化可以通过修改/etc/crontab文件以及使用crontab命令实现，其结果是一样的

- /etc/crontab文件是cron的默认配置文件，
- minute hour day month dayofweek user-name comman
- 45 4 1,10,22 * * root /root/backup.sh
  //在每月1、10、22日的4:45执行/root/backup.sh文件
- 20 1 * * 6,0 root /bin/find / -name core -exec rm {} \;
  //在每星期六、星期日的1:20执行一个find命令，查找相应的文件
- 在/etc/cron.d目录中创建文件来实现任务计划
- 使用crontab命令可以创建、修改、查看以及删除crontab条目。
- 以普通账号zhangsan登录系统，创建用户crontab条目。
- su - zhangsan
- crontab -e //使用“crontab -e”命令打开vi编辑器,编辑用户zhangsan的crontab条目
- 以root用户列出zhangsan的crontab。
- crontab -u zhangsan -l
- 以普通用户zhangsan列出自己的crontab
- contab -l
- 删除crontab时也会删除/var/spool/cron目录中指定用户的文件
- 以用户root删除zhangsan的crontab
- crontab -u zhangsan -r
- 以普通用户zhangsan删除自己的crontab。crontab -r

## linux系统启动过程

Linux系统的启动是从计算机开机通电自检开始直到登录系统需要经过的多个过程

1.bios自检

- 加电post自检,post工作是对硬件进行检查

- 进行本地设备的枚举和初始化

- bios由两部分组成:post代码和运行时服务.

- 当post完成后,它被从内存中清理出来,完成bios运行时服务依然保留在内存中

  

2.启动grub 2

grub 2是linux系统中默认使用的引导加载程序,引导加载程序 是用于引导操作系统启动.

3.加载内核

加载内核映像到内存中,内核映像并不是一个可执行的内核,而是一个压缩过的内核映像

- 检查所有硬件设备
- 驱动硬件设备
- 以只读的方式挂载根文件系统
- 启动systemd服务

4.执行systemd进程

systemd进程是系统所有进程的起点,内核在完成核内引导以后,即在本进程空间内加载systemd程序

- systemd进程是所有进程的发起者和控制者

systemd进程的作用:

- 1.扮演终结父进程的角色
- 在进入某个特定的服务启动集合,他的这个作用是由运行目标target定义的.

5.初始化系统环境

Linux系统使用systemd作为引导管理程序，之后的引导过程将由systemd完成。

Systemd使用目标（target）来处理引导和服务管理过程

- systemd执行的第一个目标是default.target但实际上default.target是指向graphical.target的软链接，
- 在执行graphical.target阶段，会启动multi-user.target，这个target为多用户支持设定系统环境，非root用户会在这个阶段的引导过程中启用，防火墙相关的服务也会在这个阶段启动
- multi-user.target会将控制权交给basic.target。basic.target用于启动普通服务特别是图形管理服务,basic.target之后将控制权交给sysinit.targe
- sysinit.target会启动重要的系统服务，例如系统挂载、内存交换空间和设备、内核补充选项等，sysinit.target在启动过程中会传递给local-fs.target和swap.targ
- local-fs.target和swap.target不会启动用户相关的服务，它只处理底层核心服务，这两个target会根据/etc/fstab和/etc/inittab来执行相关操作。

6.执行/bin/login程序

login程序会提示使用者输入账号及密码，接着编码并确认密码的正确性，如果账号与密码相符，则为使用者初始化环境，并将控制权交给shell，即等待用户登录。

## 维护GRUB2

使用引导加载程序可以引导操作系统的启动,一般情况下引导加载程序都安装在MBR(主引导扇区)中

主引导记录本身要包含两类内容:引导加载程序和分区表

- grub是linux系统默认的引导加载程序,
- linux安装程序允许用户快速方便的配置引导加载程序,将其存放在主硬盘驱动的主引导记录中来引导操作系统
- GNU GRUB是一个将引导加载程序安装到主引导记录的程序，主引导记录是位于一个硬盘开始的扇区。
- GRUB支持直接和链式加载的引导方法。
- GRUB 2采用模块化动态加载的思想，相比GRUB来讲不用在构建时将所有功能都加入，这使得GRUB 2的体积相比变得很小，整个GRUB 2的内核映像可以控制在31KB
  - 图形接口
  - 使用模块机制,通过动态加载需要的模块来扩展功能
  - 支持脚本语言,比如条件判断,循环,变量和函数
  - 支持救援模式,可以用于系统无法引导的情况
  - 国际化语言
  - 有一个灵活的命令行接口
  - 针对文件系统,文件,设备,驱动,终端,命令,分区表,系统加载的模块化,层次化,基于对象的框架
  - 支持多种文件系统格式
  - 可以访问已经安装在设备上的数据
  - 支持自动解压
  - grub2以fd表示软盘,hd表示硬盘





## 设置GRUB 2加密



# 十二、 linux网络基本配置

## 常用配置文件

- 在/etc/sysconfig/network-scripts目录下,其中文件ifcfg-eno16777736包含一块网卡的配置信息，文件ifcfg-lo包含回路IP地址信息。
- /etc/resolv.conf文件是由域名解析器（resolver，一个根据主机名解析IP地址的库）使用的配置文件
- 主机名到IP地址的匹配。这些匹配信息存放在/etc/hosts文件中,在没有域名服务器的情况下，系统上的所有网络程序都通过查询该文件来解析对应于某个主机名的IP地址
- /etc/services文件定义了Linux系统中所有服务的名称、协议类型、服务的端口等信息

## 常用的系统命令

traceroute,ifconfig,ping,netstat,arp,tcpdump

- traceroute:显示数据包到目标主机之间的路径,可以使用户可以追踪网络数据包的路由途径
- traceroute [选项] [主机名|IP地址] [数据包大小]
- 例:跟踪本地计算机到www.163.com网站的路径
- traceroute www.163.com
- ifconfig :可以显示和配置网络接口,比如ip地址,mac地址,激活或关闭网络接口
- ifconfig [接口] [选项| IP地]
- 配置网卡eno16777736的ip地址,同时激活该设备
-  ifconfig eno16777736 192.168.0.100 netmask 255.255.255.0 up
- 配置网卡eno16777736别名设备eno16777736:1的IP地址。
-  ifconfig eno16777736:1 192.168.0.3
- 激活网卡eno16777736:1设备
-  ifconfig eno16777736:1 up
- 查看网卡eno16777736网络接口的配置
- ifconfig eno16777736
- 禁用网卡eno16777736:1设备。
-  ifconfig eno16777736:1 down
- 更改网卡eno16777736的硬件MAC地址为00:0C:29:18:2E:3D。
-  ifconfig eno16777736 hw ether 00:0C:29:18:2E:3D
- ping [选项] [目标] //返回ICMP数据包
- 测试与192.168.0.222计算机的连通性，每次发送的ICMP数据包大小为128字节
-  ping -s 128 192.168.0.222
- 测试与192.168.0.5计算机的连通性，要求返回4个ICMP数据包。
-  ping -c 4 192.168.0.5
- netstat命令用来显示网络状态的信息，得知整个Linux系统的网络情况，比如网络连接、路由表、接口统计、伪装连接和组播成员
- netstat [选项] [延迟]
- 显示内核路由表信息 netstat -r
- 显示端口号为22的连接情况。netstat -antu | grep 22
- 显示UDP传输协议的链接状态 netstat -u
- arp命令可以用来增加,删除和显示ARP缓存条目
- arp [选项] [ip地址] [MAC地址]
- 添加一个IP地址和MAC地址的对应记录。
-  arp -s 192.168.0.99 00:60:08:27:CE:B2
- 删除一个IP地址和MAC地址的对应缓存记录。
- arp -d 192.168.0.99
- tcpdump 是强大的网络数据采集分析工具之一,可以将网络中传送的数据包的头完全截获下来提供分析。它支持针对网络层、协议、主机、网络或端口的过滤，并提供and、or、not等逻辑语句来筛选信息。
- 使用指定的网络接口eno16777736读取数据链路层的数据包头
-  tcpdump -i eno16777736

### systemd简介

服务管理工作是由System V通过/etc/rc.d/init.d目录下的Shell脚本来执行的，通过这些脚本允许管理员控制服务的状态。

systemd单元文件放置位置

- /usr/lib/systemd/system：systemd默认单元文件安装目录；
- /etc/systemd/system：系统管理员创建和管理的单元目录，优先级最高
- systemctl [选项] [单元命令|单元文件命]
- 启动named服务。
-  systemctl start named.service
- 查看named服务当前状态
-  systemctl status named.service
- 停止named服务 . systemctl stop named.service 
- 重新启动named服务. systemctl restart named.service
- 重新加载named服务配置文件。 systemctl reload named.service
- 设置named服务开机自动启动. systemctl enable named.service
- 查询named服务是否开机自动启动。 systemctl is-enabled named.service
- 停止named服务开机自动启动。systemctl disable named.service
- 查看所有已启动的服务. systemctl list-units  --type=service

# 十三、SSH

- ssh是强化安全的远程登录方式
- ssh将包括密码在内的所有数据都进行了加密处理，可以进行更安全的远程操作

ssh的安装 与使用

- 使用 yum install openssh安装ssh服务器
- 启动ssh服务器：systemctl start sshd
- 开机自动启动：systemctl enable sshed

公钥

- 生成公钥对：ssh-keygen -t rsa //-t选择加密方式
- 将公钥上传到服务器：cd /root/.ssh/  && ssh-copy-id  -i  id_rsa.pub  root@172.25.0.11

scp:scp 是 linux 系统下基于 ssh 登陆进行安全的远程文件拷贝命令，scp 是加密的，rcp是不加密的，scp 是 rcp 的加强版。

sftp:是安全文件传送协议。可以为传输文件提供一种安全的网络的加密方法。。SFTP 为 SSH的其中一部分，是一种传输档案至 Blogger 伺服器的安全方式。

ssh是强化安全的远程登录方式

# 十四、VNC

vnc是一种由AT&T开发的远程控制软件，可以运行于局域网和Internet,将远端的图形桌面显示到本地

# 十五、LVM

lvm是逻辑卷管理

- 它是linux环境下对磁盘分区进行管理的一种机制
- 屏蔽了底层磁盘布局，便于动态调整磁盘容量  /boot分区用于存放引导文件，不能应用LVM机制

基本概念：

- PV：物理卷，整个硬盘，或使用fdisk等工具建立的普通分区
- VG：卷组，一个或多个物理卷组合而成的整体
- LV:逻辑卷，从卷组中分割出一块空间，用于建立文件系统



创建逻辑卷步骤：

- 新建空分区
  - fdisk -c  /dev/vdb
  - fdisk -l   //查看分区

- 初始化分区
- 创建卷组
- 创建逻辑卷



### linux发行版：

一些组织和公司，将linux系统的内核，应用软件和文档包装起来，并提供一些系统安装界面、系统配置设定管理工具，就构成了linux发行版。常见的发行版red hat,suse,ubuntu,centos,debian,oracle

### 系统运行级别

运行级别0：系统停机状态，系统默认运行级别不能设为0，否则不能正常启动
运行级别1：单用户工作状态，root权限，用于系统维护，禁止远程登陆
运行级别2：多用户状态(没有NFS)
运行级别3：完全的多用户状态(有NFS)，登陆后进入控制台命令行模式
运行级别4：系统未使用，保留
运行级别5：X11控制台，登陆后进入图形GUI模式
运行级别6：系统正常关闭并重启，默认运行级别不能设为6，否则不能正常启动

查看运行级别：who -r  查看运行级别用：runlevel

进入其它运行级别用：init N

### shell程序的创建过程

shell程序就是放在一个文件中的一系列linux命令和实用程序，在执行的时候，通过Linux系统一个接一个地解释和执行每个命令，这和widows系统下的批处理程序非常相似

1.创建文件

2.开头：#!/bin/bash

3.设置可执行权限  chmod u+x /root/date

4.执行：./root/date 或 bash /root/date    (如果不设置文件的可执行权限，那么需要使用bash命令告诉系统它是一个可执行的脚本)

### 安装linux至少几个分区

- swap:交换分区
- boot:用来存放与linux系统启动有关的程序,比如引导装载程序
- /usr分区:存放linux系统中的应用程序
- /var分区:存放Linux系统中经常变化的数据以及日志文件
- /分区:linux系统根目录,所有目录都挂载这个目录下
- /home分区:存放普通用户的数据,是普通用户的宿主目录

还有opt,bin,dev,tmp,sbin等

### 写出fdisk子命令

- m 显示所有能在fdisk中使用的子命令
- p 显示磁盘分区信息
- a 设置磁盘启动分区
- n 创建新的分区
- e 创建扩展分区
- p 创建主分区
- t 更改分区的系统ID（也就是分区类型ID）
- d 删除磁盘分区
- q 退出fdisk，不保存磁盘分区设置
- l 列出已知的分区类型
- v 验证分区表
- w 保存磁盘分区设置并退出fdisk

### 进程的启动方式：

1.system函数，调用shell进程

2.exec系列函数，替换进程映像

3.fork函数，复制进程映像

### 修改权限的方式

1.文字设定法设置权限  chmod u+w a 对文件a,给用户（u）增加写（w）权限，chmod u+rw,g+r,o+rwx a

2.数字设定法设置权限：chmod 700 a

### yum有什么作用

1.自动化地升级、安装和删除RPM软件包，

2.收集RPM软件包的相关信息，

3.检查依赖性并且一次安装所有依赖的软件包，无须繁琐地一次次安装 

### ssh,scp,sftp

scp:scp 是 linux 系统下基于 ssh 登陆进行安全的远程文件拷贝命令，scp 是加密的，rcp是不加密的，scp 是 rcp 的加强版。

sftp:是安全文件传送协议。可以为传输文件提供一种安全的网络的加密方法。。SFTP 为 SSH的其中一部分，是一种传输档案至 Blogger 伺服器的安全方式。

ssh是强化安全的远程登录方式

### 使用命令启动named服务，并设置开机自启

- 启动named服务。
- systemctl start named.service
- 查看named服务当前状态
- systemctl status named.service
- 停止named服务 . systemctl stop named.service 
- 重新启动named服务. systemctl restart named.service
- 重新加载named服务配置文件。 systemctl reload named.service
- 设置named服务开机自动启动. systemctl enable named.service
- 查询named服务是否开机自动启动。 systemctl is-enabled named.service
- 停止named服务开机自动启动。systemctl disable named.service

```sh
#!/bin/bash
for((i=1;i<=50;i++))
do
        mkdir userdata/user$i;
        chmod 4754 userdata/user$i;

done

```

