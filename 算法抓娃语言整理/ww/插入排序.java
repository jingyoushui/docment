package com.qimo.undo;
/*
Description

实现插入排序。


Input

输入第一行为用例个数， 每个测试用例输入的每一行代表一个数组，其中的值用空格隔开，第一个值表示数组的长度。


Output

输出排序的数组，用空格隔开，末尾不要空格。


Sample Input 1

1
13 24 3 56 34 3 78 12 29 49 84 51 9 100
Sample Output 1

3 3 9 12 24 29 34 49 51 56 78 84 100
* */


import java.util.Scanner;

public class 插入排序 {

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {    //当前要排序的位置下标，下标从1开始
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {  //从这个要排序的下标位置的前一个位置向0下标遍历。
                // j >= 0 && arr[j] > arr[j + 1] 是移动条件
                swap(arr, j, j + 1);
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
        int count = scanner.nextInt();
        scanner.nextLine();
        while(count-- > 0)
        {
            int[] ints = setIntArrayWithInputLineExcept0(scanner);
            insertionSort(ints);
            displayArr(ints);
        }
    }
}
