package com.qimo.undo;
import java.util.Scanner;


/*
Description

判断一个单向链表是否为回文结构。自定义链表数据结构，要求时间复杂度为O(n)，额外空间复杂度为O(1)。


Input

输入第一行为用例个数， 每个测试用例输入的每一行的值用空格隔开，第一个值为节点个数，后面为每一个节点值


Output

是回文则输出true，不是则输出false，一行表示一个链表的结果。


Sample Input 1

4
3 1 2 1
4 1 2 2 1
3 3 5 3
6 a b c d c a
Sample Output 1

true
true
true
false
* */
public class 链表回文 {
   static class ListNode {
        String value;
        ListNode next;
        ListNode(String value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numOfCases; i++) {
            // 接收输入
            String[] input = scanner.nextLine().split(" ");
            // 1.建立链表
            ListNode head = null;
            ListNode current = null;
            for (int j = 1; j < input.length; j++) {
                ListNode tempNode = new ListNode(input[j]);
                if (j == 1) {
                    head = tempNode;
                    current = tempNode;
                } else {
                    current.next = tempNode;
                    current = tempNode;
                }
            }
            // 2.判断是否为回文
            System.out.println(isPlalindrome(head));
        }
        scanner.close();
    }

    // 判断该单向链表是否为回文链表
    public static boolean isPlalindrome(ListNode leftHead) {
        // 链表长度为一则肯定是回文
        if (leftHead.next == null) {
            return true;
        }
        // 长度不为一的情况下进行正常判断
        // 1.找到中间位置
        // （利用快慢指针：slow位置在奇数长度下停到中间，偶数长度下停到中间两个的第一个位置）
        ListNode fast = leftHead.next;
        ListNode slow = leftHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 2.倒置右边
        ListNode curNode = slow.next;
        slow.next = null;   // 断开左右
        ListNode rightHead = null;
        while (curNode != null) {
            ListNode nextNode = curNode.next;  // 表示下一个结点
            curNode.next = rightHead;   // 当前结点倒置连接
            rightHead = curNode;    // 指向新头结点
            curNode = nextNode;     // 到下一个结点准备下次倒置
        }
        // 3.比较两边确定结果
        while (leftHead != null && rightHead != null && leftHead.value.equals(rightHead.value)) {
            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }
        // 判断是否遍历过整个左右两链，没有则表示中途有不对称的值，即不是回文链
        if (rightHead == null) {
            return true;
        } else {
            return false;
        }
    }

}
