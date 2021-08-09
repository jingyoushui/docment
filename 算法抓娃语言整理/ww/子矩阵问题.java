package com.qimo.undo;
import java.util.*;
/*
Description

给定一个矩形区域，每一个位置上都是1或0，求该矩阵中每一个位置上都是1的最大子矩形区域中的1的个数。


Input

输入第一行为测试用例个数。每一个用例有若干行，第一行为矩阵行数n和列数m，下面的n行每一行是用空格隔开的0或1。


Output

输出一个数值。


Sample Input 1

1
3 4
1 0 1 1
1 1 1 1
1 1 1 0
Sample Output 1

6
* */

public class 子矩阵问题 {

    public static int get(int []arr){
        int max = 0;
        for(int i=0;i<arr.length;i++){
            int left = (i==0)?0:i-1;
            int right = (i==arr.length-1)?arr.length-1:i+1;
            while (left>=0&& arr[i]<=arr[left])
                left--;
            while (right<arr.length && arr[i]<=arr[right])
                right++;
            int sum=(right-left-1)*arr[i];
            max=max>sum?max:sum;
        }
        return  max;
    }
    public  static int maxSize(int [][]arr){
        int res[]=new int[arr[0].length];
        int max=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                res[j]=(arr[i][j]==0) ? 0:(res[j]+1);
            }
            int sum=get(res);
            max=max>sum? max:sum;
        }
        return max;
    }
    public static void main(String args[]){

        //ystem.out.println(Arrays.toString(maxSize(arr)));

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        for (int j = 0; j <num ; j++) {
            int m=scanner.nextInt();
            int n=scanner.nextInt();
            scanner.nextLine();
            int[][] B=new int[m][n];
            int k=0;
            while(k<m&&scanner.hasNextLine())
            {
                String[] str1=scanner.nextLine().split(" ");
                for(int i=0;i<str1.length;i++)
                    B[k][i]=Integer.parseInt(str1[i]);
                k++;
            }

            System.out.println(maxSize(B));
        }

    }

}


