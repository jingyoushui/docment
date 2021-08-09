package com.qimo.undo;
/*
Description

对给定数组中的元素按照元素出现的次数排序，出现次数多的排在前面，如果出现次数相同，则按照数值大小排序。例如，给定数组为{2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12}，则排序后结果为{3, 3, 3, 3, 2, 2, 2, 12, 12, 4, 5}。


Input

输入的第一行为用例个数；后面每一个用例使用两行表示，第一行为数组长度，第二行为数组内容，数组元素间使用空格隔开。


Output

每一个用例的排序结果在一行中输出，元素之间使用空格隔开。


Sample Input 1

1
4
2 3 2 5
Sample Output 1

2 2 3 5
* */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class 按照数值个数排序 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int cases = scanner.nextInt();
            for(int i=0; i<cases; i++){
                int nums = scanner.nextInt();
                int[] array = new int[nums];
                for(int j=0; j<nums; j++){
                    array[j] = scanner.nextInt();
                }
                sortValue(putInMap(array));
            }
        }
        public static Map<Integer, Integer> putInMap(int[] array){
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int i=0; i<array.length; i++){
                if (!map.containsKey(array[i])) {
                    map.put(array[i], 1);
                }else {
                    map.put(array[i], map.get(array[i])+1);
                }
            }
            return map;
        }
        public static void sortValue(Map<Integer, Integer> map){
            ArrayList<Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
            list.sort(new Comparator<Entry<Integer, Integer>>() {
                @Override
                public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                    if (o1.getValue()<o2.getValue() || o1.getValue()==o2.getValue() && o1.getKey()>o2.getKey()) {
                        return 1;
                    }else {
                        return -1;
                    }
                }
            });
            for(int i=0; i<list.size(); i++){
                Entry<Integer, Integer> e = list.get(i);
                for(int j=0;j<e.getValue()&&i!=list.size()-1;j++){
                    System.out.print(e.getKey()+" ");
                }
                if (i==list.size()-1) {
                    for(int j=0;j<e.getValue()-1;j++){
                        System.out.print(e.getKey()+" ");
                    }
                    System.out.println(e.getKey());
                }
            }
        }

}
