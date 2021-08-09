package com.qimo.undo;

import java.util.Scanner;

/*Description

        实现计数排序，通过多次遍历数组，统计比每一个元素小的其它元素个数，根据该统计量对数据进行排序。


        Input

        输入的每一行表示一个元素为正整数的数组，所有值用空格隔开，第一个值为数值长度，其余为数组元素值。


        Output

        输出的每一行为排序结果，用空格隔开，末尾不要空格。
13 24 3 56 34 3 78 12 29 49 84 51 9 100
13 24 3 56 34 3 78 12 29 49 84 51 9 100
13 24 3 56 34 3 78 12 29 49 84 51 9 100

        Sample Input 1

        13 24 3 56 34 3 78 12 29 49 84 51 9 100
        Sample Output 1

        3 3 9 12 24 29 34 49 51 56 78 84 100*/
public class 计数排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext())
        {
            String str = scanner.nextLine();
            String[] s = str.split(" ");
            int[] ints = new int[s.length-1];  //第一个值表示数组的长度！！！！！！！！！

            for (int j = 1; j <s.length ; j++) {
                ints[j-1]=Integer.parseInt(s[j]);
            }
            sort_CountSum(ints);
            show_arr(ints);


        }
    }
    public static  void sort_CountSum(int[] ints)
    {
        int ints_max=Integer.MIN_VALUE;
        int ints_min=Integer.MAX_VALUE;
        for (int i = 0; i < ints.length; i++) {
            if(ints[i]>ints_max)ints_max=ints[i];
            if(ints[i]<ints_min)ints_min=ints[i];
        }
        int[] ints1 = new int[ints_max-ints_min+1];

        for (int j = 0; j <ints.length ; j++) {
             int index=ints[j]-ints_min;
            ints1[index]++;
        }
        int index=0;
        for (int i = 0; i <ints1.length ; i++) {

          while(ints1[i]>0)
          {
              ints[index]=i+ints_min;
              ints1[i]--;
              index++;
          }

        }


    }
    public static void show_arr(int[] a)
    {
        for (int i = 0; i < a.length; i++) {
            if(i==a.length-1)
            {
                System.out.println(a[i]);
            }
            else
            {
                System.out.print(a[i]+" ");
            }
        }

    }
}
