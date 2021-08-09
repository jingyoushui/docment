package com.qimo.undo;
/*
* Description

Implement pow(A, B) % C.In other words, given A, B and C, find (A^B)%C


Input

The first line of input consists number of the test cases. The following T lines consist of 3 numbers each separated by a space and in the following order:A B C'A' being the base number, 'B' the exponent (power to the base number) and 'C' the modular.Constraints:1 ≤ T ≤ 70,1 ≤ A ≤ 10^5,1 ≤ B ≤ 10^5,1 ≤ C ≤ 10^5


Output

In each separate line print the modular exponent of the given numbers in the test case.


Sample Input 1

3
3 2 4
10 9 6
450 768 517
Sample Output 1

1
4
34
* */

import java.util.Scanner;

/**
 * 思路：
 * 直接乘方再求余超出long的范围
 * 所以每乘一次就求一次的余
 * 快速幂更好，但是这样也可以过
 *
 */


public class 数学公式 {

    static int power(int x, int y, int p) {
        // Initialize result
        int res = 1;

        for (int i = 0; i < y; i++) {
            res *= x;
            res %= p;
        }
        return res;
    }

    // Driver Program to test above functions
    public static void main(String args[])
    {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int p = sc.nextInt();
            System.out.println(power(x, y, p));
        }
    }
}
