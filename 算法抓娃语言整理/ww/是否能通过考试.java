package com.qimo.undo;
import java.util.Scanner;

/*
Description

小张想要通过明天的考试。他知道考题的分值分布，也知道考试中要拿到每一个题目需要耗费的时间。假设考试时长为h，共n个题目，需要拿到p分才能通过考试。现在已知每个考题的得分与耗时，请你判断小张能否通过合理安排时间，而通过考试，并给出通过考试的最短时间。


Input

输入第一行为测试用例个数.每一个用例有若干行，第一行为任务数量n、考试时常h、通过分数p，下面的n行是每一个题目的耗时和得分。所有数值用空格分开。


Output

对每一个用例输出一行，如果能够通过考试，则输出“YES”和消耗最短时间，用空格隔开。 否则，输出“NO”。


Sample Input 1

1
5 40 21
12 10
16 10
20 10
24 10
8 3
Sample Output 1

YES 36
* */
public class 是否能通过考试 {

    public static int getResult (int n, int h, int p, int[] score, int[] time) {
        int[] dp = new int[h + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = h; j >= 1; j--) {
                if (j - time[i] >= 0)
                    dp[j] = Math.max(dp[j], dp[j - time[i]] + score[i]);
            }
        }
        //System.out.println(Arrays.toString(dp));
        for (int j = 1; j <= h; j++) {
            if (dp[j] >= p)
                return j;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rounds = Integer.valueOf(scan.nextLine());
        for (int i = 0; i < rounds; i++) {
            String line = scan.nextLine();
            String[] arr = line.split(" ");
            int n = Integer.valueOf(arr[0]);
            int h = Integer.valueOf(arr[1]);
            int p = Integer.valueOf(arr[2]);
            int[] score = new int[n + 1];
            int[] time = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                String problem = scan.nextLine();
                String[] pro = problem.split(" ");
                time[j] = Integer.valueOf(pro[0]);
                score[j] = Integer.valueOf(pro[1]);
                //System.out.println("time"+time[j] + ", score:" + score[j]);
            }
            int res = getResult(n, h, p, score, time);
            if (res == -1)
                System.out.println("NO");
            else
                System.out.println("YES " + res);
        }

    }

}
