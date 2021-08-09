package com.qimo.undo;
/*Description

Consider a string A = "12345". An infinite string s is built by performing infinite steps on A recursively. In i-th step, A is concatenated with ‘$’ i times followed by reverse of A. A=A|$...$|reverse(A), where | denotes concatenation.

Constraints:1<=Q<=10^5, 1<=POS<=10^12


Input

输入第一行为查询次数，后面为每次查询的具体字符位置。


Output

输出每一次查询位置上的字符。


Sample Input 1

2
3
10
Sample Output 1

3
2*/
/**
 * 思路：每次新字符串s的长度都是上一个翻倍加上i(i是第几次翻倍)
 * 题目的关键就是将pos的位置转换为“12345$54321”的位置
 * 实践证明，每次将s字符串的长度再加上它递归的次数的一半恰好是那次递归刚开始的地方
 * 不断循环最后就
 */
import java.util.Scanner;

public class 无限递归字符串查询 {
    public static void main (String[] args) {
        final String PAT = "12345$54321";

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            long pos = in.nextLong();
            if (pos == 0) System.out.println("");//特殊情况
            while (pos > PAT.length()) {
                long[] iter = findIter(pos); //找到对应pos字符串s应该需要多长，及递归的次数
                long start = (iter[0] + iter[1]) / 2; //找到新一次递归最开始的地方
                pos -= start; //找到pos在最新递归产生的字符串的位置(由于后半段和前半段一样，不断循环最终会在前11位里）
            }

            char res;
            if (pos <= 0) { //当pos <= 0的时候，说明pos在最新一次递归产生的$符那里
                res = '$';
            } else {
                res = PAT.charAt((int)pos - 1);
            }
            System.out.println(res);
        }
    }

    private static long[] findIter(long pos) {
        long len = 5; //字符初始长度
        int it = 0; //递归次数
        while (pos > len) {
            it++;
            len = len * 2 + it;
        }
        return new long[] {len, it};
    }
}
