package com.qimo.undo;
/*
Description

按照给定的起始顶点广度优先遍历图，每一次通过字母顺序选择顶点查找下一层邻接点，打印遍历顺序。


Input

输入第一行为测试用例个数，后面每一个用例用多行表示，用例第一行是节点个数n和开始顶点，用空格隔开，后面n+1行为图的邻接矩阵，其中第一行为节点名称。值之间使用空格隔开。


Output

输出遍历顺序，用空格隔开


Sample Input 1

1
4 a
a b c d
a 0 1 1 0
b 1 0 1 0
c 1 1 0 1
d 0 0 1 0
Sample Output 1

a b c d
* */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
public class 广度优先遍历图 {


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int cases = scanner.nextInt();
            for(int i=0; i<cases; i++){
                int n = scanner.nextInt();
                char start = scanner.next().charAt(0);
                char[] all = new char[n];
                Map<Character, Integer> map = new HashMap<Character, Integer>();//目前还没被找到的元素集合
                Set<Character> set = new TreeSet<Character>();	//记录某一层,用于遍历
                set.add(start);
                Set<Character> set2 = new TreeSet<Character>(set);//记录某一层,用于添加新元素
                for(int j=0; j<n; j++){
                    char c = scanner.next().charAt(0);
                    map.put(c,j);
                    all[j] = c;
                }
                int[][] array = new int[n][n];
                for(int j=0; j<n; j++){
                    scanner.next();
                    for(int k=0; k<n; k++){
                        array[j][k] = scanner.nextInt();
                    }
                }
                Map<Character, Integer> map2 = new HashMap<Character, Integer>(map);//保存下标
                int count=0;
                while(!map.isEmpty()){
                    Iterator<Character> iterator2 = set2.iterator();
                    while (iterator2.hasNext()) {
                        Character c = (Character) iterator2.next();
                        System.out.print(c);
                        if(count!=n-1){
                            System.out.print(" ");
                        }
                        map.remove(c);
                        iterator2.remove();
                        count++;
                    }
                    Iterator<Character> iterator = set.iterator();
                    while (iterator.hasNext()) {
                        Character c = (Character) iterator.next();
                        for(int k=0; k<n; k++){
                            if (map.containsKey(all[k]) && array[map2.get(c)][k]==1) {
                                set2.add(all[k]);
                            }
                        }
                    }
                    set = new TreeSet<Character>(set2);
                }
                System.out.println();
            }
        }

}
