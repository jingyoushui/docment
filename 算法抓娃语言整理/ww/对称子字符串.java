package com.qimo.undo;

import java.util.Scanner;

/*
Description

Given a string ‘str’ of digits, find length of the longest substring of ‘str’, such that the length of the substring is 2k digits and sum of left k digits is equal to the sum of right k digits.


Input

输入第一行是测试用例的个数，后面每一行表示一个数字组成的字符串，例如："123123"


Output

输出找到的满足要求的最长子串的长度。例如，给定的例子长度应该是 6。每行对应一个用例的结果。


Sample Input 1

1
1538023
Sample Output 1

4
* */
public class 对称子字符串 {
    //思路1：最简单的方法就是遍历里面所有的子字符串，取它们满足条件的最大值（考试想不出来可以直接这样写，时间可以过去）
    static int findLength(String str) {
        int n = str.length();
        int maxlen = 0; // 初始化结果

        for (int i = 0; i < n; i++) { //将所有的子字符串都遍历一下，因为要对称，字符串长度一定是偶数
            for (int j = i + 1; j < n; j += 2) {
                int length = j - i + 1; //计算字符串长度
                int leftsum = 0, rightsum = 0;
                for (int k = 0; k < length/2; k++) { //计算对称的左右两边的数字的总和
                    leftsum += (str.charAt(i + k) - '0');
                    rightsum += (str.charAt(i + k + length/2) - '0');
                }

                // 更新结果+
                if (leftsum == rightsum && maxlen < length)
                    maxlen = length;
            }
        }
        return maxlen;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        while(N-- >0) {
            String str = sc.nextLine();
            System.out.println(findLength(str));
        }
    }
}
