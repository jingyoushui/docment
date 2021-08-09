package com.qimo.undo;

import java.util.Scanner;

/*
Description

将单个链表的每K个节点之间逆序，打印出新链表；最后不足K的节点数不需要逆序；要求时间复杂度为O(n)，额外空间复杂度为O(1)。


Input

输入第一行为用例个数， 每个测试用例输入的每一行的值用空格隔开，第一个表示链表长度，中间为节点值，最后代表K。


Output

输出的每一行为新的链表，节点值用空格隔开，末尾不要空格。


Sample Input 1

2
8 1 2 3 4 5 6 7 8 3
8 a b c d e f g h 4
Sample Output 1

3 2 1 6 5 4 7 8
d c b a h g f e
* */
public class 链表区间逆序 {
    private static int T;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        T = in.nextInt();
        in.nextLine();
        while (T-- != 0) {
            String s = in.nextLine();
            String[] dataStr = s.split(" ");

            int n = Integer.valueOf(dataStr[0]);
            if (n == 0){
                print();
                continue;
            }
            int spaceCnt = n-1;
            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = dataStr[i+1];
            }
            int k = Integer.parseInt(dataStr[dataStr.length-1]);
            if (k == 0){
                for (int i = 0; i < n; i++) {
                    System.out.print(strings[i]);
                    if (spaceCnt-- != 0){
                        System.out.print(" ");
                    }
                }
                print();
                continue ;
            }
            if (k > n){
                for (int i = 0; i < n; i++) {
                    System.out.print(strings[i]);
                    if (spaceCnt-- != 0){
                        System.out.print(" ");
                    }
                }
                print();
                continue ;
            }
            int point = -1;
            while (point + k < n){
                for (int i = 0; i < k; i++) {
                    System.out.print(strings[point + k - i]);
                    if (spaceCnt-- != 0){
                        System.out.print(" ");
                    }
                }
                point += k;
            }
            if (point < n){
                for (int i = point + 1; i < n; i++) {
                    System.out.print(strings[i]);
                    if (spaceCnt-- != 0){
                        System.out.print(" ");
                    }
                }
            }
            print();
        }
    }


    private static void print(){
        if (T == 0){
            System.out.println();
        }else{
            System.out.println();
        }
    }
}