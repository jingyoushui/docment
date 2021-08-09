package com.qimo.undo;
import java.io.*;
import java.util.*;
/*
Description

Archana is very fond of strings. She likes to solve many questions related to strings. She comes across a problem which she is unable to solve. Help her to solve. The problem is as follows: Given is a string of length L. Her task is to find the longest string from the given string with characters arranged in descending order of their ASCII code and in arithmetic progression. She wants the common difference should be as low as possible(at least 1) and the characters of the string to be of higher ASCII value.


Input

The first line of input contains an integer T denoting the number of test cases. Each test contains a string s of lengthL.

1<= T <= 100

3<= L <=1000

A<=s[i]<=Z

The string contains minimum three different characters.


Output

For each test case print the longest string.Case 1:Two strings of maximum length are possible- “CBA” and “RPQ”. But he wants the string to be of higher ASCII value therefore, the output is “RPQ”.Case 2:The String of maximum length is “JGDA”.


Sample Input 1

2
ABCPQR
ADGJPRT
Sample Output 1

RQP
JGDA
* */
//https://blog.csdn.net/qq_33935895/article/details/103111573
public class 和最大的连续降序字符 {
        public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0) {
                char[] s = sc.next().toCharArray();
                boolean[] ch = new boolean[26];
                for(int i = 0; i<s.length; i++)
                    ch[s[i]-'A'] = true;
                String res = "";
                for(int i = 1; i<26; i++) {
                    for(int j = 25; j>=0; j--) {
                        if(ch[j]) {
                            String temp = "";
                            temp+=(char)('A'+j);
                            for(int k = j-i; k>=0; k-=i) {
                                if(ch[k])
                                    temp+=(char)('A'+k);
                                else
                                    break;
                            }
                            if(temp.length()>res.length())
                                res = temp;
                        }
                    }
                }
                System.out.println(res);
            }
        }


}
