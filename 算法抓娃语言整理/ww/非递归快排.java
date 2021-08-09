package com.qimo.undo;

import java.util.Scanner;
import java.util.Stack;

/*Description

        快速排序的核心思想是使用元素的值对数组进行划分。实现其非递归方案。


        Input

        输入的每一行表示一个元素为正整数的数组，所有值用空格隔开，第一个值为数值长度，其余为数组元素值。


        Output

        输出的每一行为排序结果，用空格隔开，末尾不要空格。


        Sample Input 1

        13 24 3 56 34 3 78 12 29 49 84 51 9 100
        Sample Output 1

        3 3 9 12 24 29 34 49 51 56 78 84 100*/
public class 非递归快排 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext())
        {
            String str = scanner.nextLine();
            String[] s = str.split(" ");
            int[] ints = new int[s.length-1];    //第一个值表示数组的长度！！！！！！！！！

            for (int j = 1; j <s.length ; j++) {
                ints[j-1]=Integer.parseInt(s[j]);
            }
            QuickSort(ints,0,ints.length-1);
            show_arr(ints);


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

    //借助栈
    public  static int  partsort(int[] array, int left, int right)
    {
        //基准值
        int ponit = array[left];

        //坑的位置
        int temp = left;

        while (left <= right)
        {
            while (left <= right)
            {
                if (array[right] < ponit)
                {
                    array[left] = array[right];
                    ++left;
                    temp = right;
                    break;
                }
                else
                    --right;
            }
            while (left <= right)
            {
                if (array[left] > ponit)
                {
                    array[right] = array[left];
                    --right;
                    temp = left;
                    break;
                }
                else
                    ++left;
            }

        }
        array[temp] = ponit;
        return temp;
    }

    public  static  void QuickSort(int[] array, int left, int right)
    {

        Stack<Integer> s = new Stack<Integer>();

        s.push(left);

        s.push(right);

        while (!s.empty())
        {
            right = s.peek();
            s.pop();
            left = s.peek();
            s.pop();

            //划分左右部分的边界线
            int Index = partsort(array, left, right);

            //左半部分
            if (Index - 1 > left)
            {
                s.push(left);
                s.push(Index - 1);
            }

            //右半部分
            if (Index + 1 < right)
            {
                s.push(Index + 1);
                s.push(right);
            }
        }

    }
}
