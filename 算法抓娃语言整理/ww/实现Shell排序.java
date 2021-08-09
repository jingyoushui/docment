package com.qimo.undo;

import java.util.Scanner;

/*
Description

实现Shell排序，对给定的无序数组，按照给定的间隔变化（间隔大小即同组数字index的差），打印排序结果，注意不一定是最终排序结果！


Input

输入第一行表示测试用例个数，后面为测试用例，每一个用例有两行，第一行为给定数组，第二行为指定间隔，每一个间隔用空格隔开。


Output

输出的每一行为一个用例对应的指定排序结果。


Sample Input 1

1
49 38 65 97 76 13 27 49 55 4
5 3
Sample Output 1

13 4 49 38 27 49 55 65 97 76
* */
public class 实现Shell排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        while(count-- >0) {
            int[] ints = setIntArrayWithInoutLine(scanner);
            int[] gaps = setIntArrayWithInoutLine(scanner);
            shellSort(ints,gaps);
            displayArr(ints);

        }
    }
    //显示数组
    public static void displayArr(int[] a)
    {
        for (int i = 0; i < a.length; i++) {
            if(i!=a.length-1)
            {
                System.out.print(a[i]+" ");
            }
            else
            {
                System.out.print(a[i]);
            }
        }
        System.out.println();
    }
    //光标从本行头开始，从键盘输入一串数字(在一行，以空格隔开)后生成数组，光标返回到下一行的开始
    public static int[] setIntArrayWithInoutLine(Scanner sc)
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
    /**
     * 希尔排序
     * @param arr 待排数组
     */
    public static void shellSort(int[] arr,int a[]) {
        for(int w=0; w<a.length; w++) { /*步长逐渐减小*/
            int gap=a[w];
            for(int i=gap; i<arr.length; i++) { /*在同一步长内*/
                //同一步长内排序方式是插入排序
                int temp = arr[i], j; //待排元素
                //j-gap代表有序数组中最大数的下标，j-pag表示有序数组的前一个元素，减pag是减去偏移量就是步长
                for(j=i; j>=gap && temp<arr[j-gap]; j-=gap)
                    arr[j] = arr[j-gap]; //原有序数组最大的后移一位
                arr[j] = temp; //找到了合适的位置插入
            }
        }
    }


}
