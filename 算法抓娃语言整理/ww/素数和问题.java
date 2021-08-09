package com.qimo.undo;
import java.util.Scanner;
/*
Description

Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number. There are several combinations possible. Print only first such pair.

NOTE: A solution will always exist, read Goldbach’s conjecture.Also, solve the problem in linear time complexity, i.e., O(n).


Input

The first line contains T, the number of test cases. The following T lines consist of a number each, for which we'll find two prime numbers.Note: The number would always be an even number.


Output

For every test case print two prime numbers space separated, such that the smaller number appears first. Answer for each test case must be in a new line.


Sample Input 1

5
74
1024
66
8
9990
Sample Output 1

3 71
3 1021
5 61
3 5
17 9973
* */


public class 素数和问题 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int count=s.nextInt();
        int a[]=new int[count];
        for (int i = 0; i < count; i++) {
            a[i]=s.nextInt();

        }
        //当p+q的和为给定数时，判断其是否为素数如果是则打印输出
        for (int j = 0; j < a.length; j++) {
            for (int q = 3; q <=a[j]/2; q++) {
                if (isPrime(q)&&isPrime(a[j]-q)){
                    System.out.print(q);
                    System.out.print(" ");
                    System.out.println(a[j]-q);
                    break;
                }



            }

        }

    }



    //判定是否为素数
    public static boolean isPrime(int n){

        for (int i=2;i<=(int)Math.sqrt(n);i++){
            if (n%i==0) return false;
        }
        return true;
    }

}