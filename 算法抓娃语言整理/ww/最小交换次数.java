package com.qimo.undo;
/*
Description

Given an array of N distinct elementsA[ ], find the minimum number of swaps required to sort the array.Your are required to complete the function which returns an integer denoting the minimum number of swaps, required to sort the array.


Input

The first line of input contains an integer T denoting the no of test cases . Then T test cases follow . Each test case contains an integer N denoting the no of element of the array A[ ]. In the next line are N space separated values of the array A[ ] .(1<=T<=100;1<=N<=100;1<=A[] <=1000)


Output

For each test case in a new line output will be an integer denoting minimum umber of swaps that are required to sort the array.


Sample Input 1

2
4
4 3 2 1
5
1 5 4 3 2
Sample Output 1

2
2
* */
import java.util.Arrays;
import java.util.Scanner;
public class 最小交换次数 {



        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            while (N-- > 0) {
                int len = sc.nextInt();
                int[] arr = new int[len];
                for (int i = 0; i < len; i++) {
                    arr[i] = sc.nextInt();
                }
                minSwap(arr, len);
            }
        }

        private static void minSwap(int[] arr, int len) {
            int[] newArr = new int[len];
            for (int i = 0; i < len; i++) {
                newArr[i] = arr[i];
            }
            Arrays.sort(newArr);
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (arr[i] == newArr[i]) {
                    continue;
                } else {
                    int k = 0; //k = arr.index(newArr[i]);
                    for (int j = 0; j < arr.length; j++) {
                        if (arr[j] == newArr[i]) {
                            k = j;
                            break;
                        }
                    }
                    //swap(arr[i],arr[k])
                    int temp = arr[i];
                    arr[i] = arr[k];
                    arr[k] = temp;
                    count++;
                }
            }
            System.out.println(count);
        }
}

