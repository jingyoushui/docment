package com.qimo.undo;

import java.util.Scanner;
/*
*Description

实现冒泡排序。


Input

输入的每一行表示一个元素为正整数的数组，所有值用空格隔开，第一个值为数值长度，其余为数组元素值。


Output

输出的每一行为排序结果，用空格隔开，末尾不要空格。


Sample Input 1

13 24 3 56 34 3 78 12 29 49 84 51 9 100
Sample Output 1

3 3 9 12 24 29 34 49 51 56 78 84 100
* */
public class 冒泡排序 {

        public static void bubbleSort(int[] arr) {
            if (arr == null || arr.length < 2) {
                return;
            }
            for (int e = arr.length - 1; e > 0; e--) { //每次找出一个位置上的最大元素，从下标为length-1开始。
                for (int i = 0; i < e; i++) {
                    if (arr[i] > arr[i + 1]) {
                        swap(arr, i, i + 1);   //出现arr[i] > arr[i + 1]的情况，就交换。
                    }
                }
            }
        }
        public static void swap(int[] arr, int i, int j) {
           arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];

        }
        //光标从本行头开始，从键盘输入一串数字(在一行，以空格隔开)后生成数组，光标返回到下一行的开始,第一个元素不存储
        public static int[] setIntArrayWithInputLineExcept0(Scanner sc)
        {
            // Scanner sc = new Scanner(System.in);
            String str = sc.nextLine().toString();
            String[] arr  = str.split(" ");
            int[] b = new int[arr.length-1];
            for(int j = 0; j<b.length;j++) {
                b[j] = Integer.parseInt(arr[j+1]);
            }
            return b;
        }
        //显示数组
        public static void displayArr(int[] a)
        {
            for (int i = 0; i < a.length; i++) {
                if(i!=a.length-1)
                {System.out.print(a[i]+" ");}
                else
                {
                    System.out.print(a[i]);
                }
            }
            System.out.println();
        }


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNextLine())
            {
                int[] ints = setIntArrayWithInputLineExcept0(scanner);
                bubbleSort(ints);
                displayArr(ints);
            }
        }

}
