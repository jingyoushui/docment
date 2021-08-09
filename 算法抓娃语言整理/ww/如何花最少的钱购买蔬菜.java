package com.qimo.undo;
/*
Description

Rahul wanted to purchase vegetables mainly brinjal, carrot and tomato. There are N different vegetable sellers in a line. Each vegetable seller sells all three vegetable items, but at different prices. Rahul, obsessed by his nature to spend optimally, decided not to purchase same vegetable from adjacent shops. Also, Rahul will purchase exactly one type of vegetable item (only 1 kg) from one shop. Rahul wishes to spend minimum money buying vegetables using this strategy. Help Rahul determine the minimum money he will spend.


Input

First line indicates number of test cases T. Each test case in its first line contains N denoting the number of vegetable sellers in Vegetable Market. Then each of next N lines contains three space separated integers denoting cost of brinjal, carrot and tomato per kg with that particular vegetable seller.


Output

For each test case, output the minimum cost of shopping taking the mentioned conditions into account in a separate line.

Constraints:1 <= T <= 101 <= N <= 100000 Cost of each vegetable(brinjal/carrot/tomato) per kg does not exceed 10^4


Sample Input 1

1
3
1 50 50
50 50 50
1 50 50
Sample Output 1

52
* */
import java.util.*;
public class 如何花最少的钱购买蔬菜 {




        public static int findLastLeast(int[][] matrix,int row,int col){
            int min=0;
            if(matrix[row-1][(col+1)%3] < matrix[row-1][(col+2)%3]){
                min = matrix[row-1][(col+1)%3];
            }else{
                min = matrix[row-1][(col+2)%3];
            }
            return min;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            sc.nextLine();
            while(N-- > 0){
                int row = Integer.parseInt(sc.nextLine());
                int[][] matrix = new int[row][3];
                for(int i = 0; i < row; i ++){
                    String[] rowdata = sc.nextLine().split(" ");
                    for(int j=0;j<3;j ++){
                        matrix[i][j] = Integer.parseInt(rowdata[j]);
                    }
                }
                for(int i = 1;i < row; i++){
                    for(int j = 0; j < 3; j++){
                        matrix[i][j] += findLastLeast(matrix,i,j);
                    }
                }
                int minmoney = Integer.MAX_VALUE;
                for(int i = 0; i < 3; i++){
                    if(matrix[row - 1][i] < minmoney){
                        minmoney = matrix[row-1][i];
                    }
                }
                System.out.println(minmoney);
            }
        }

}
