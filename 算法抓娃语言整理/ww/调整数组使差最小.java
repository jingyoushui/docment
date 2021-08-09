package com.qimo.undo;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/*
Description

有两个序列 a,b，大小都为 n,序列元素的值任意整数，无序； 要求：通过交换 a,b 中的元素，使[序列 a 元素的和]与[序列 b 元素的和]之间的差最小。


Input

输入第一行为用例个数， 每个测试用例输入为两行，分别为两个数组，每个值用空格隔开。


Output

输出变化之后的两个数组内元素和的差绝对值。


Sample Input 1

1
100 99 98 1 2 3
1 2 3 4 5 40
Sample Output 1

48
Language:


* */
public class 调整数组使差最小 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        for(int i = 0;i < n;i++){
            List<Integer> re1 = new LinkedList<>();
            List<Integer> re2 = new LinkedList<>();
            String s1 = sc.nextLine();
            String[] array = s1.split(" ");
            for(int j = 0;j < array.length;j++){
                re1.add(Integer.valueOf(array[j]));
            }
            String s2 = sc.nextLine();
            String[]array2 = s2.split(" ");
            for(int j = 0;j < array2.length;j++){
                re2.add(Integer.valueOf(array2[j]));
            }
            System.out.println(helper(re1,re2));
        }
    }
    public static int helper(List<Integer>list1,List<Integer> list2){
        if(list1 == null || list2 == null || list1.size() == 0 || list2.size() == 0 || list1.size() != list2.size()){
            return 0;
        }

        int sum = 0;
        List<Integer> list = new LinkedList<>(list1);
        list.addAll(list2);
        int len = list.size();
        for(int i = 0;i < list.size();i++){
            sum += list.get(i);
        }

        int[][]dp = new int[len / 2 + 1][sum / 2 + 1];
        for(int i = 0;i <= len / 2;i++){
            for(int j = 0;j <= sum / 2;j++){
                if (i == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = -1;
                }
            }
        }


        for(int i = 1;i <= list.size();i++){
            for(int j = i > len / 2 ? len / 2 : i;j >= 1;j--){
                for(int v = list.get(i - 1);v <= sum / 2;v++){
                    if (dp[j - 1][v - list.get(i - 1)] < 0) {
                        continue;
                    }
                    else if (dp[j - 1][v - list.get(i - 1)] + list.get(i - 1) > dp[j][v]) {
                        dp[j][v] = dp[j - 1][v - list.get(i - 1)] + list.get(i - 1);
                    }
                }
            }
        }
        return sum - 2 * dp[len/2][sum/2];
    }
}