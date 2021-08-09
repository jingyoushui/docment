package com.qimo.undo;
import java.util.Scanner;
/*
Description

Given an array, the task is to complete the function which finds the maximum sum subarray, where you may remove at most one element to get the maximum sum.


Input

第一行为测试用例个数T；后面每两行表示一个用例，第一行为用例中数组长度N，第二行为数组具体内容。


Output

每一行表示对应用例的结果。


Sample Input 1

1
5
1 2 3 -4 5
Sample Output 1

11
Hint

例如，对一个数组A[] = {1, 2, 3, -4, 5}，要移除-4得到最大和的子数组，和为11.
* */
public class 数组查询 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            while (N-- > 0) {
                int len = sc.nextInt();
                int[] arr = new int[len];
                for (int i = 0; i < len; i++) {
                    arr[i] = sc.nextInt();
                }
                int res = maxArrSum(arr);
                System.out.println(res);
            }

        }



        //看不懂的kadane
        private static int maxArrSum(int[] arr) {
            int sum = arr[0];
            int max = arr[0];
            int skip = arr[0];
            for (int i = 1; i < arr.length; i++) {
                int temp = sum;
                sum += arr[i];
                sum = Math.max(sum, arr[i]);
                skip = Math.max(temp, skip + arr[i]);
                temp = Math.max(sum, skip);
                max = Math.max(temp, max);

            }
            return max;
        }





}
