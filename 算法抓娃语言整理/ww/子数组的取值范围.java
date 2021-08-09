package com.qimo.undo;
/*
Description

给定数组arr和整数num，求arr的连续子数组中满足：其最大值减去最小值的结果大于num的个数。请实现一个时间复杂度为O(length(arr))的算法。


Input

输入第一行为测试用例个数。每一个用例有若干行，第一行为数组，每一个数用空格隔开，第二行为num。


Output

输出一个值。


Sample Input 1

1
3 6 4 3 2
2
Sample Output 1

6
* */


import java.util.Scanner;

public class 子数组的取值范围 {



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i <num ; i++) {
            int[] arr=setIntArrayWithoutNum(scanner);
            int sum = Integer.parseInt(scanner.nextLine());
            System.out.println(getNum(arr,sum));
        }
    }
    //从键盘输入一串数字(在一行，以空格隔开)后生成数组
    public static int[] setIntArrayWithoutNum(Scanner sc)
    {
        // Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toString();
        String[] arr  = str.split(" ");
        int[] b = new int[arr.length];
        for(int j = 0; j<b.length;j++) {
            b[j] = Integer.parseInt(arr[j]);
        }
        return b;

    }

    //暴力获取所有子数组
    public static int getNum(int[] arr, int num) {
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            int max = arr[i], min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (max < arr[j]) max = arr[j];
                if (min > arr[j]) min = arr[j];
                if (max - min > num) {
                    res++;
                }
            }
        }
        return res;
    }




}
