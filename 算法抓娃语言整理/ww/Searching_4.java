package com.qimo.undo;
import java.text.DecimalFormat;
import java.util.Scanner;
/*
Searching_4
Description

Given n Magnets which are placed linearly, with each magnet to be considered as of point object. Each magnet suffers force from its left sided magnets such that they repel it to the right and vice versa. All forces are repulsive. The force being equal to the distance (1/d , d being the distance). Now given the positions of the magnets, the task to find all the points along the linear line where net force is ZERO.

Note: Distance have to be calculated with precision of 0.0000000000001.

Constraints:1<=T<=100,1<=N<=100,1<=M[]<=1000


Input

The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. The second line of each test case contains an integer N. Then in the next line are N space separated values of the array M[], denoting the positions of the magnet.


Output

For each test case in a new line print the space separated points having net force zero till precised two decimal places.


Sample Input 1

2
2
1 2
4
0 10 20 30
Sample Output 1

1.50
3.82 15.00 26.18
*/
public class Searching_4 {

        static int n, x, index;

        static double a[];

        static double force(double m) {
            double distance = 0;
            for (int i = 0; i <= index; i++) {

                distance = distance - 1 / (m - a[i]);
            }

            for (int i = index + 1; i < x; i++) {

                distance = distance + 1 / (a[i] - m);
            }

            // System.out.println(distance);
            return (distance);
        }

        public static void main(String args[]) {
            {
                Scanner sc = new Scanner(System.in);

                n = sc.nextInt();
                while (n-- > 0) {
                    x = sc.nextInt();
                    a = new double[x];
                    for (int i = 0; i < x; i++) {
                        a[i] = sc.nextInt();
                    }
                    index = 0;
                    for (int i = 0; i < x - 1; i++) {
                        index = i;
                        double l = a[i];
                        double h = a[i + 1];
                        while (l < h) {

                            double mid = (l + h) / 2.00;
                            DecimalFormat df = new DecimalFormat(".######");
                            double force = Double.valueOf(df.format(force(mid)));
                            if (force > 0) {
                                h = mid - 0.0000000000001;
                            } else if (force < 0) {
                                l = mid + 0.0000000000001;
                            } else if (force == 0) {
                                DecimalFormat df1 = new DecimalFormat(".##");
                                if(i!=x-2)
                                {System.out.print(String.format("%.2f", Double.valueOf(df1.format(mid))) + " ");}  else
                                { System.out.print(String.format("%.2f", Double.valueOf(df1.format(mid))));}

                                break;
                            }

                        }//while
                    }
                    System.out.println();

                }
            }
        }
    }

