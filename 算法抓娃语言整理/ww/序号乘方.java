package com.qimo.undo;
/*
Description

There are Infinite People Standing in a row, indexed from 1.A person having index 'i' has strength of (i*i).You have Strength 'P'. You need to tell what is the maximum number of People You can Kill With your Strength P.You can only Kill a person with strength 'X' if P >= 'X' and after killing him, Your Strength decreases by 'X'.


Input

First line contains an integer 'T' - the number of testcases,Each of the next 'T' lines contains an integer 'P'- Your Power.Constraints:1<=T<=100001<=P<=1000000000000000


Output

For each testcase Output The maximum Number of People You can kill.


Sample Input 1

1
14
Sample Output 1

3
* */

/**
 * 思路：
 * 可能是在考贪心。从最小的按顺序杀杀的是最多的。
 */

import java.util.Scanner;
public class 序号乘方 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N-- > 0) {
            long p = sc.nextLong();
            long i = 1; //从1开始杀
            int count = 0;//记录能杀多少
            while (p >= i * i) {
                count++;
                p -= i * i;
                i++;
            }
            System.out.println(count);
        }
    }
}