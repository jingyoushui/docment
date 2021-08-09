package com.qimo.undo;

import java.io.*;
import java.lang.*;
/*
Description

You are given N number of books. Every ith book has Pi number of pages. You have to allocate books to M number of students. There can be many ways or permutations to do so. In each permutation one of the M students will be allocated the maximum number of pages. Out of all these permutations, the task is to find that particular permutation in which the maximum number of pages allocated to a student is minimum of those in all the other permutations, and print this minimum value. Each book will be allocated to exactly one student. Each student has to be allocated atleast one book.


Input

The first line contains 'T' denoting the number of testcases. Then follows description of T testcases:Each case begins with a single positive integer N denoting the number of books.The second line contains N space separated positive integers denoting the pages of each book.And the third line contains another integer M, denoting the number of studentsConstraints:1<= T <=70，1<= N <=50，1<= A [ i ] <=250，1<= M <=50，Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see explanation for better understanding)


Output

For each test case, output a single line containing minimum number of pages each student has to read for corresponding test case.


Sample Input 1

1
4
12 34 67 90
2
Sample Output 1

113
* */
//参考：https://ide.geeksforgeeks.org/FFrJBhpTJD
//参考：https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages/0/?track=placement&amp;batchId=
public class 书本分发
{
    static boolean isPossible(int arr[], int n, int m, int curMin)
    {
        int studentsRequired = 1;
        int curSum = 0;

        for (int i = 0; i < n; i++) {

            if (arr[i] > curMin) return false;

            if (curSum + arr[i] > curMin) {

                studentsRequired++;
                curSum = arr[i];
                if (studentsRequired > m) return false;
            }
            else {
                curSum += arr[i];
            }
        }
        return true;
    }

    static int solve(int A[], int n, int m)
    {

        long sum = 0;
        if(n < m) return -1;

        for(int i = 0; i < n; ++i)
            sum += A[i];


        long start = 0;
        long end = sum, mid = 0;
        int ans = Integer.MAX_VALUE;

        while(start <= end)
        {

            mid = (start + end) / 2;

            if (isPossible(A, n, m, (int)mid) == true) {

                ans = Math.min(ans, (int)mid);
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }
        return ans;

    }
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");

            int A[] = new int[n];
            for(int i = 0; i < n; i++)
            {
                A[i] = Integer.parseInt(st[i]);
            }
            int m = Integer.parseInt(read.readLine());
            System.out.println(solve(A, n, m));

        }
    }
}