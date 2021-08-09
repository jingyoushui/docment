## java算法基础

## list

实现list接口的两个类：

- ArrayLiat
- LinkedList

ArrayList由数组备份。链接列表由链接列表备份。

如果我们频繁地访问列表的元素，那么` ArrayList `会表现得更好。访问ArrayList中的元素更快，因为它是数组后端。

从` ArrayList `添加或删除元素更慢除非从头到尾，因为` ArrayList `必须执行数组副本内部保持元素的顺序。

`LinkedList `的性能优于` ArrayList `用于添加和从列表中间删除元素。但是，访问列表中的元素更慢，除非在列表的头部。

### ArrayList

```java
		List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("2");
        list.add("1");
        list.add("1");
        System.out.println(String.join(" ",list));//可以使用空格将元素隔开 1 2 2 1 1
```

**常用方法**

```java
public static void a3(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("2");
        list.add("1");
        list.add("1");
        list.add(5,"0");//根据索引添加
        list.remove(0);//根据索引删除元素
        list.remove("2");//根据对象删除，只删除第一个
        list.set(0,"0");//根据索引更新数据
        System.out.println("list.size():"+list.size());
        System.out.println("list.contains(\"1\"):"+list.contains("1"));//是否包含某个元素


        System.out.println(String.join(" ",list));
        System.out.println(list.indexOf("2"));//从前面开始搜索

        for(String s:list){
            System.out.print(s+" ");
        }
        System.out.println();
        Object[] list2 =  list.toArray();//转换为数组
        System.out.println(list2[2]);
        System.out.println(list.get(2));

        String[] array = {"0", "1","1","0"};
        List<String> list3 = Arrays.asList(array);//数组转换为list

        System.out.println(list.subList(1,3));//list中索引从1到3，包括1不包括3
        System.out.println(list.equals(list3));//判断两个list是否相等

        List<String> list4 = new ArrayList<>();
        for(int i=1;i<5;i++){
            list4.add(i+"");
        }
        System.out.println(list4);
        System.out.println(list4.lastIndexOf("3"));//从末尾开始搜索

//        我们可以使用 ListIterator 接口以遍历列表。
//ListIterator 接口继承了 Iterator 接口并且它增加了几个方法来从当前位置向后访问列表中的元素。
        ListIterator<String> fullInterator = list.listIterator();//从列表中获取列表迭代器
        while (fullInterator.hasNext()) {
            int index = fullInterator.nextIndex();
            String element = fullInterator.next();
            System.out.println("Index=" + index + ", Element=" + element);
        }
        
        ListIterator<String> partialIterator = list.listIterator(2);//得到正向从2开始的迭代器
        while (partialIterator.hasNext()) {
            int index = partialIterator.nextIndex();
            String element = partialIterator.next();//next()方法向前移动一个索引，而 previous()方法向后移动一个索引。
            System.out.println("Index=" + index + ", Element=" + element);
        }

    }
```

今天在刷剑指offer的时候，刷到了从上到下打印二叉树那题，需要使用队列来辅助实现。在JAVA中，我们常用LinkedList来模拟链式队列，发现好久没用LinkedList了，对它有一些陌生，因此整理一下，这里主要针对的是他的方法尤其是特有的方法。

增加：
add(E e)：在链表后添加一个元素；   通用方法
addFirst(E e)：在链表头部插入一个元素；  特有方法
addLast(E e)：在链表尾部添加一个元素；  特有方法
push(E e)：与addFirst方法一致  
offer(E e)：在链表尾部插入一个元素                                                                                                                                                  add(int index, E element)：在指定位置插入一个元素。      
offerFirst(E e)：JDK1.6版本之后，在头部添加； 特有方法                                                                                                         offerLast(E e)：JDK1.6版本之后，在尾部添加； 特有方法

删除：
remove() ：移除链表中第一个元素;    通用方法  
remove(E e)：移除指定元素；   通用方法
removeFirst(E e)：删除头，获取元素并删除；  特有方法
removeLast(E e)：删除尾；  特有方法
pollFirst()：删除头；  特有方法
pollLast()：删除尾；  特有方法
pop()：和removeFirst方法一致，删除头。 
poll()：查询并移除第一个元素     特有方法    

查：
get(int index)：按照下标获取元素；  通用方法
getFirst()：获取第一个元素；  特有方法
getLast()：获取最后一个元素； 特有方法
peek()：获取第一个元素，但是不移除；  特有方法
peekFirst()：获取第一个元素，但是不移除； 
peekLast()：获取最后一个元素，但是不移除；
pollFirst()：查询并删除头；  特有方法
pollLast()：删除尾；  特有方法
poll()：查询并移除第一个元素     特有方法
————————————————
版权声明：本文为CSDN博主「yyyyyhu」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/huyang0304/article/details/82389595

ArrayList转数组

  Integer[] arr = list.toArray(new Integer[list.size()]);

  String[] array = {"0", "1","1","0"};
   List<String> list3 = Arrays.asList(array);//数组转换为list