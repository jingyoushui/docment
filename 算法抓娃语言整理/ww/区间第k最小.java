package com.qimo.undo;



import java.util.Scanner;

/*
Description

找到给定数组的给定区间内的第K小的数值。


Input

输入第一行为用例个数， 每个测试用例输入的第一行为数组，每一个数用空格隔开；第二行是区间（第几个数到第几个数，两头均包含），两个值用空格隔开；第三行为K值。


Output

结果。


Sample Input 1

1
1 2 3 4 5 6 7
3 5
2
Sample Output 1

4
*/

public class 区间第k最小 {
   /* public static int  getNum()
    {

    }*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int all=scanner.nextInt();
        for (int i = 0; i <all ; i++) {
            scanner.nextLine();
            int[] ints = setIntArrayWithoutNum(scanner);
            int low=scanner.nextInt();
            int high=scanner.nextInt();
            scanner.nextLine();
            int k=scanner.nextInt();
            quickSort(ints,low-1,high-1);
            System.out.println(ints[low-1+k-1]);
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
