package com.qimo.undo;
import java.util.Scanner;

/*
Description

输入一个数组和一个数字，在数组中查找两个数，使得它们的和正好是输入的那个数字，统计这样两个数的对数。


Input

输入第一行为用例个数， 每个测试用例输入第一行是数组，每一个数用空格隔开；第二行是数字和。


Output

输出这样两个数有几对。


Sample Input 1

1
1 2 4 7 11 0 9 15
11
Sample Output 1

3
*/
public class 固定和的元素对 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
                int count=scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i <count ; i++) {
                    int[] arr = setIntArrayWithoutNum(scanner);
                    quickSort(arr, 0, arr.length - 1);
                    int all = Integer.parseInt(scanner.nextLine());
                System.out.println(findSumNum(arr,all));
            }
        }

        public  static int findSumNum(int[] arr,int all)
    {
        int i = 0, j = arr.length - 1;
        int sum=0;
        while (i != j) {
            if (arr[i] + arr[j] == all) {
                sum++;
            }
            if ((arr[i] + arr[j] > all)) {
                j--;
            } else {
                i++;
            }
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
    //快速排序
    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }
}
