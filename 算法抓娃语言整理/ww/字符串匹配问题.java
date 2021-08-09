package com.qimo.undo;

import java.util.Scanner;

/*
字符串匹配问题
Description

Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[]. You may assume that n > m.


Input

输入第一行是用例个数，后面一行表示一个用例；用例包括两部分，第一部分为给定文本，第二部分为搜索串，两部分使用","隔开。


Output

每一个用例输出一行，每行按照找到的位置先后顺序排列，使用空格隔开。


Sample Input 1

2
THIS IS A TEST TEXT,TEST
AABAACAADAABAABA,AABA

Sample Output 1

10
0 9 12

1
THIS IS A TEST TEXT,TEST
 */
//leetcode 028
//https://blog.csdn.net/u013275928/article/details/71104798
public class 字符串匹配问题 {
    public static void search(char[] txt,char[] pat)
    {
        int m=pat.length;   //搜索串的长度
        int n=txt.length;  //给定文本的长度
        int count=0;      //匹配成功次数，用来处理输出
        for(int i=0;i<=n-m;i++)   //i下标>n-m 没必要讨论了
        {
            int j;      //一次匹配中，字符匹配相同的移动下标
            for(j=0;j<m;j++)
            {
                if(txt[i+j]!=pat[j])  //中途发现不匹配，跳出
                {
                    break;
                }
            }
            if(j==m)         //匹配成功
            {
                count++;
                if(count==1)
                {System.out.print(i);}   //如果是第一次输出，前面不加空格
                else
                {
                System.out.print(" "+i); //如果不是第一次输出，前面加空格
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        while(count>0)
        {
            String s = scanner.nextLine();
            String[] strs = s.split(",");
            search(strs[0].toCharArray(),strs[1].toCharArray());
            count--;
        }

    }
}
