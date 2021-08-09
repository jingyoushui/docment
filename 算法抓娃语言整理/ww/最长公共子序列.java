package com.qimo.undo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
Description

给定两个字符串，返回两个字符串的最长公共子序列（不是最长公共子字符串），可能是多个。


Input

输入第一行为用例个数， 每个测试用例输入为两行，一行一个字符串


Output

如果没有公共子序列，不输出，如果有多个则分为多行，按字典序排序。


Sample Input 1

1
1A2BD3G4H56JK
23EFG4I5J6K7
Sample Output 1

23G456K
23G45JK
* */
public class 最长公共子序列 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        int cases = Integer.valueOf(input.nextLine());
        while(cases > 0) {
            cases--;
            String str1 = input.nextLine();
            String str2 = input.nextLine();
            firWay(str1, str2);
        }

    }
    /**
     *
     * <p>Title: firWay</p>
     * <p>Description:
     * 应用动态规划的方法查找两字符串最长的公共子序列
     * i=0 || j=0 -->  count[i][j] = 0
     * i>0 && j>0 && str1[i-1]==str2[j-1]  -->  count[i][j] = count[i-1][j-1] + 1
     * i>0 && j>0 && str1[i-1]!=str2[j-1]  -->  count[i][j] = max{count[i-1][j],count[i][j-1]}
     * </p>
     * @param str1
     * @param str2
     */
    public static void firWay(String str1, String str2) {
        int[][] count = new int[str1.length()+1][str2.length()+1];
        int maxLen = 0;
        for(int i=1; i<str1.length()+1; i++) {
            for(int j=1; j<str2.length()+1;j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    count[i][j] = count[i-1][j-1] + 1;
                }
                else {
                    count[i][j] = Math.max(count[i-1][j], count[i][j-1]);
                }
                if(count[i][j] > maxLen) {
                    maxLen = count[i][j];
                }
            }
        }
        //System.out.println("lenth: " + maxLen);
        List<String> maxFlag = new ArrayList<>();
        String flag;
        for(int i=1; i<str1.length()+1; i++) {
            for(int j=1; j<str2.length()+1;j++) {
                if(count[i][j] == maxLen) {
                    flag = String.valueOf(i) + " " +String.valueOf(j);
                    maxFlag.add(flag);
                }
            }
        }
        List<String> list = new ArrayList<>();
        for(int f=0; f<maxFlag.size(); f++) {
            String[] tip = maxFlag.get(f).split(" ");
            int i = Integer.valueOf(tip[0]);
            int j = Integer.valueOf(tip[1]);
            String item = "";
            findStr(list, count, str1, str2, i, j, item);
        }//for
        Collections.sort(list);
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
    /**
     *
     * <p>Title: findStr</p>
     * <p>Description:
     * 根据动态规划生成二维数组count，递归查找子序列
     *  </p>
     * @param list  子序列列表
     * @param count   动态规划生成的二维数组
     * @param str1    	字符串
     * @param str2		字符串
     * @param i		最长子序列末端坐标
     * @param j		最长子序列末端坐标
     * @param item	子序列的部分
     */
    public static void findStr(List<String> list, int[][] count, String str1, String str2, int i, int j, String item) {
        if(i==0 || j==0) {
            if(list.indexOf(item) == -1)
                list.add(item);
            return;
        }
        else {
            if(str1.charAt(i-1) == str2.charAt(j-1)) {
                String string = str1.charAt(i-1) + item;
                findStr(list, count, str1, str2, i-1, j-1, string);
            }
            else if(count[i-1][j] > count[i][j-1]){
                findStr(list, count, str1, str2, i-1, j, item);
            }
            else if(count[i-1][j] < count[i][j-1]) {
                findStr(list, count, str1, str2, i, j-1, item);
            }
            else {
                findStr(list, count, str1, str2, i-1, j, item);
                findStr(list, count, str1, str2, i, j-1, item);
            }
        }
    }
}
