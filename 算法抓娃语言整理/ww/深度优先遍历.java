package com.qimo.undo;
/*
Description

按照给定的起始顶点深度优先遍历给定的无向图，尝试所有可能的遍历方式，打印遍历过程中出现的最大深度。


Input

输入第一行是用例个数，后面每个用例使用多行表示，用例的第一行是图中节点的个数n和起始点，用空格隔开，后面n+1行为图的邻接矩阵，其中第一行为节点名称。值之间使用空格隔开。


Output

输出深度优先遍历中遇到的最大深度。


Sample Input 1

1
4 a
a b c d
a 0 1 1 0
b 1 0 1 0
c 1 1 0 1
d 0 0 1 0
Sample Output 1

4
* */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
public class 深度优先遍历 {



        public static char[] all;
        public static int length = 1;
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int cases = scanner.nextInt();
            for(int i=0; i<cases; i++){
                int n = scanner.nextInt();
                char start = scanner.next().charAt(0);
                all = new char[n];
                Map<Character, Integer> map = new HashMap<Character, Integer>();//目前还没被找到的元素集合
                List<Integer> list = new ArrayList<Integer>();	//记录某一层,用于遍历
//			Set<Character> set2 = new HashSet<Character>(set);//记录某一层,用于添加新元素
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
                list.add(new Integer(map.get(start)));
                dp(array, list, map.get(start));
                System.out.println(length);
            }
        }
        public static void dp(int[][] array, List<Integer> list,int  current){
            boolean flag = false; //表示没有子节点
            for(int i=0;i<array[current].length; i++){
                if (!list.contains(i) && array[current][i]==1) {
                    List<Integer> set2 = new ArrayList<Integer>(list);
                    set2.add(i);
                    flag = true;
                    dp(array, set2, i);
                }
            }
            if (!flag) {
//			Iterator<Integer> iterator = list.iterator();
//			while (iterator.hasNext()) {
//				Integer i = (Integer) iterator.next();
//				System.out.print(all[i]+"->");
//			}
//			System.out.println();
                length = Math.max(length, list.size());
            }
        }

}
