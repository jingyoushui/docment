package com.qimo.undo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
* 距离问题
描述

在给定的笛卡尔平面中，有N个点。我们需要找到点对数（A，B）使得

点A和点B不重合。
点之间的曼哈顿距离和欧几里得距离应相等。
注意：2点对（A，B）与2点对（B，A）相同。

曼哈顿距离= | x2-x1 | + | y2-y1 |

欧氏距离=（（x2-x1）^ 2 +（y2-y1）^ 2）^ 0.5其中点是（x1，y1）和（x2，y2）。

约束：1 <= T <= 50，1 <= N <= 2 * 10 ^ 5，0 <=（| Xi |，| Yi |）<= 10 ^ 9


输入项

第一行由T组成-测试用例的数量。对于每个测试用例：第一行包括N，点数。下一行包含N对，包含两个整数Xi和Yi，即，一个点的X坐标和Y坐标


输出量

按照上面的要求打印对数。


样本输入1

1个
2
1 1
7 5
样本输出1

0
*
* */
public class 距离问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N-- != 0) {
            int count = sc.nextInt();
            Integer[][] array = new Integer[count][2];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = sc.nextInt();
                }
            }
            System.out.println(compairDis(array));
        }
    }

    private static int compairDis(Integer[][] array) {
        Map<Integer, Integer> x = new HashMap<>();
        Map<Integer, Integer> y = new HashMap<>();
        Map<Integer[], Integer> xy = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int x_count = x.containsKey(array[i][0]) ? x.get(array[i][0]) : 0;
            x.put(array[i][0], x_count + 1);
            int y_count = y.containsKey(array[i][1]) ? y.get(array[i][1]) : 0;
            y.put(array[i][1], y_count + 1);
            int xy_count = xy.containsKey(array[i]) ? xy.get(array[i]) : 0;
            xy.put(array[i], xy_count + 1);
        }
        int xAns = 0, yAns = 0, xyAns = 0;
        for (Integer xCoordinatePair : x.keySet()) {
            int xFrequency = x.get(xCoordinatePair);
            int sameXPairs = (xFrequency * (xFrequency - 1)) / 2;
            xAns += sameXPairs;
        }
        for (Integer yCoordinatePair : y.keySet()) {
            int yFrequency = y.get(yCoordinatePair);
            int sameYPairs = (yFrequency * (yFrequency - 1)) / 2;
            yAns += sameYPairs;
        }
        for (Integer[] xyCoordinatePair : xy.keySet()) {
            int xyFrequency = xy.get(xyCoordinatePair);
            int sameXYPairs = (xyFrequency * (xyFrequency - 1)) / 2;
            xyAns += sameXYPairs;
        }
        return (xAns + yAns - xyAns);
    }
}
