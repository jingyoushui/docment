package com.qimo.undo;
/*
Description

Given an array of positive integers and many queries for divisibility. In every query Q[i], we are given an integer K , we need to count all elements in the array which are perfectly divisible by K.

Constraints:1<=T<=1001<=N,M<=1051<=A[i],Q[i]<=105


Input

The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of three lines. First line of each test case contains two integers N & M, second line contains N space separated array elements and third line contains M space separated queries.


Output

For each test case,In new line print the required count for each query Q[i].


Sample Input 1

2
6 3
2 4 9 15 21 20
2 3 5
3 2
3 4 6
2 3
Sample Output 1

3 3 2
2 2
*/


import java.util.Scanner;

/**
 * 整除查询
 * Given an array of positive integers and many queries for divisibility.
 * In every query Q[i], we are given an integer K , we need to count all elements in the array which are perfectly divisible by K.
 *
 * Constraints:1<=T<=1001<=N,M<=1051<=A[i],Q[i]<=105
 *
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of three lines.
 * First line of each test case contains two integers N & M, second line contains N space separated array elements and third line contains M space separated queries.
 *
 * For each test case,In new line print the required count for each query Q[i].
 *
 * 题目大意
 * 输入一组数，再输入一组数，问你上面那组数能整除下面那组数有多少个
 * 第一行输入用例个数，第二行输入N，M（N是被除数，M是除数），第三行输入N个被除数，第四行输入M个除数
 * 输入每个除数可以被上面几个被除数整除
 *
 */


public class 整除查询 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];//输入n个被除数
            int[] div = new int[m];//输入m个除数
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                div[i] = sc.nextInt();
            }
            int[] res = new int[m];//存放结果数组
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[j] % div[i] == 0)
                        res[i]++;
                }
            }

            for (int i = 0; i < m - 1; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println(res[m - 1]);
        }
    }
}