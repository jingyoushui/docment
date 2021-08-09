package com.qimo.undo;
/*
Description

给定一个整型数组arr和一个大小为w的窗口，窗口从数组最左边滑动到最右边，每次向右滑动一个位置，求出每一次滑动时窗口内最大元素的和。


Input

输入第一行为用例个数， 每个测试用例输入的第一行为数组，每一个元素使用空格隔开；第二行为窗口大小。


Output

输出每个测试用例结果。


Sample Input 1

1
4 3 5 4 3 3 6 7
3
Sample Output 1

32
* */


import java.util.Scanner;

public class 数组和窗口 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i <num ; i++) {
            int[] arr=setIntArrayWithoutNum(scanner);
            int sum = Integer.parseInt(scanner.nextLine());
            System.out.println(getSum(arr,sum));
        }

    }


    public static int getSum(int[] arr,int w)
    {
        int[] midarr=new int[w];
        int sum=0;
        for (int i = 0; i <=arr.length-w ; i++) {
            for (int j = i; j <w+i ; j++) {
                midarr[j-i]=arr[j];
            }
            sum= sum+getArrMax(midarr);
        }
        return sum;
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
    //获取数组中的最大值
    public static int getArrMax(int[] arr)
    {
        int max=arr[0];
        for (int i = 1; i <arr.length; i++) {
            if(max<arr[i])
            {
                max=arr[i];
            }
        }
        return max;
    }
}

