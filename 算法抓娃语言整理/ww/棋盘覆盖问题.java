package com.qimo.undo;

import java.util.Scanner;

/*
Description

棋盘覆盖问题：给定一个大小为2^n2^n个小方格的棋盘，其中有一个位置已经被填充，现在要用一个L型（22个小方格组成的大方格中去掉其中一个小方格）形状去覆盖剩下的小方格。求出覆盖方案，即哪些坐标下的小方格使用同一个L型格子覆盖。注意：坐标从0开始。左上方的第一个格子坐标为(0,0)，第一行第二个坐标为(0,1)，第二行第一个为(1,0)，以此类推。


Input

输入第一行为测试用例个数，后面每一个用例有两行，第一行为n值和特殊的格子的坐标（用空格隔开），第二行为需要查找其属于同一个L型格子的格子坐标。


Output

输出每一行为一个用例的解，先按照行值从小到大、再按照列值从小到大的顺序输出每一个用例的两个坐标；用逗号隔开。


Sample Input 1

1
1 1 1
0 0
Sample Output 1

0 1,1 0
* */
public class 棋盘覆盖问题 {

    static int[][] L_Matrix = new int[][] {
            new int[]{1,1,-1,-1},
            new int[]{1,0,-1,-1},
            new int[]{2,0,0,3},
            new int[]{2,2,3,3}};

    static int[][] direction = new int[][] {new int[]{0, 1},
            new int[]{-1, 0}, new int[]{0, -1}, new int[]{1, 0}};
    //下，左，上，右

    public static int[] nearRange(int n, int pX, int pY, int tX, int tY) {
        int d = (int)Math.pow(2, n - 1);
        //System.out.println("~~"+d+","+pX +"," + pY +","+tX+","+tY);
        if (pX / d == tX / d && pY / d == tY / d) {
            //System.out.println("缩小");
            int boardX = pX / d * d;
            int boardY = pY / d * d;
            return nearRange(n - 1, pX - boardX, pY - boardY, tX - boardX, tY - boardY);
        }
        else {
            return getResult(n, pX, pY, tX, tY);
        }
    }

    public static int[] getResult(int n, int px, int py, int targetX, int targetY) {
        /** 先找到空点的位置，确定整体布局 */
        //System.out.println("原x:" + targetX + "原y: " + targetY);
        int xx = px / (int)Math.pow(2, n - 1);
        int yy = py / (int)Math.pow(2, n - 1);
        int degree = 0;
        int[] position = new int[2];
        int newX = targetX;
        int newY = targetY;
        if (xx == 0 && yy == 1) {
            degree = 180;
            newX = (int) Math.pow(2, n) - 1 - targetX;
            newY = (int) Math.pow(2, n) - 1 - targetY;
        } else if (xx == 0 && yy == 0) {
            degree = 270;
            newX = (int) Math.pow(2, n) - 1 - targetY;
            newY = targetX;
        } else if (xx == 1 && yy == 1) {
            degree = 90;
            newX = targetY;
            newY = (int) Math.pow(2, n) - 1 - targetX;
        }
        //System.out.println("初始化，角度: " + degree);
        //System.out.println("newX" + newX + ", newY:" + newY);
        /** 获取新位置 */
        position = getPosition(n, newX, newY, degree);
        int[] p1 = new int[2];
        int[] p2 = new int[2];
        int degreeInv = position[1] / 90;
        if (position[0] == 0) {
            // p1-下， p2-下右
            p1[0] = direction[0 + degreeInv][0];
            p1[1] = direction[0 + degreeInv][1];
            p2[0] = p1[0] + direction[(3 + degreeInv) % 4][0];
            p2[1] = p1[1] + direction[(3 + degreeInv) % 4][1];
        }
        else if (position[0] == 1) {
            // p1-上, p2-右
            p1[0] = direction[(2 + degreeInv) % 4][0];
            p1[1] = direction[(2 + degreeInv) % 4][1];
            p2[0] = direction[(3 + degreeInv) % 4][0];
            p2[1] = direction[(3 + degreeInv) % 4][1];

        } else if (position[0] == 2) {
            // p1-左, p2-左上
            p1[0] = direction[(1 + degreeInv) % 4][0];
            p1[1] = direction[(1 + degreeInv) % 4][1];
            p2[0] = p1[0] + direction[(2 + degreeInv) % 4][0];
            p2[1] = p1[1] + direction[(2 + degreeInv) % 4][1];
        }
        //System.out.println("最终结果：position: " + position[0] + ", degree:" + degree);
        //System.out.println("p1: " + Arrays.toString(p1));
        //System.out.println("p2: " + Arrays.toString(p2));
        int[] result = new int[4];
        if (p1[0] < p2[0] || (p1[0] == p2[0] && p1[1] < p2[1])) {
            result[0] = p1[0];
            result[1] = p1[1];
            result[2] = p2[0];
            result[3] = p2[1];
        }
        else {
            result[0] = p2[0];
            result[1] = p2[1];
            result[2] = p1[0];
            result[3] = p1[1];
        }
        return result;
    }

    /** 规定为L形，左下角坐标为0,0，坐标重调为相对坐标 */
    public static int[] getPosition(int n, int x, int y, int degree) {
        /** 递归终止条件，输出相对位置和旋转角度
         *  位置：0-左上, 1-左下, 2-右下 (右上空白)
         */
        //System.out.println("n: " + n + ", x: " + x + ", y: " + y);
        if (n == 1) {
            int[] result = new int[2];
            result[1] = degree;
            if (x == 0 && y == 0)
                result[0] = 0;
            else if (x == 0 && y == 1)
                result[0] = 1;
            else if (x == 1 && y == 1)
                result[0] = 2;
            return result;
        }
        /** 递归主体 */
        int d = (int)Math.pow(2, n - 2);
        int xx = x / d;
        int yy = y / d;
        //System.out.println("xx:" + xx + ", yy:" + yy);
        int No_L = L_Matrix[yy][xx];
        //System.out.println("No_L: " + No_L);
        if (No_L == 0) {
            xx = x - d;
            yy = y - d;
        } else if (No_L == 1) {
            xx = y;
            yy = 2 * d - 1 - x;
            degree = (degree + 90) % 360;
        } else if (No_L == 2) {
            xx = x;
            yy = y - 2 * d;
        } else if (No_L == 3) {
            xx = 4 * d - 1 - y;
            yy = x - 2 * d;
            degree = (degree - 90) % 360;
        }
        return getPosition(n - 1, xx, yy, degree);

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rounds = Integer.valueOf(scan.nextLine());
        for (int i = 0; i < rounds; i++) {
            String line = scan.nextLine();
            String[] arr = line.split(" ");
            int n = Integer.valueOf(arr[0]);
            int pX = Integer.valueOf(arr[1]);
            int pY = Integer.valueOf(arr[2]);
            line = scan.nextLine();
            arr = line.split(" ");
            int tX = Integer.valueOf(arr[0]);
            int tY = Integer.valueOf(arr[1]);
            int[] result = nearRange(n,pX,pY,tX,tY);
            System.out.println((tX+result[0]) + " " + (tY+result[1]) + "," + (tX+result[2]) + " " + (tY+result[3]));

        }
    }

    /*
    public static void main(String[] args) {
        int n = 2;
        int px = 1;
        int py = 0;
        int tx = 0;
        int ty = 0;
        int[] result = nearRange(n, px, py, tx, ty);
        System.out.println(result[0] + " " + result[1] + "," + result[2] + " " + result[3]);
    }

     */

}
