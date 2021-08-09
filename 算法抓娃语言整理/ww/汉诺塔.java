package com.qimo.undo;

import java.util.Scanner;

/*
Description

汉诺塔问题中限制不能将一层塔直接从最左侧移动到最右侧，也不能直接从最右侧移动到最左侧，而是必须经过中间。求当有N层塔的时候移动步数。


Input

输入第一行为用例个数， 每个测试用例输入的第一行为N。


Output

移动步数。


Sample Input 1

1
2
Sample Output 1

8
* */
public class 汉诺塔 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <num ; i++) {
            int a = Integer.parseInt(scanner.nextLine());
            System.out.println(moveCount(a));
        }

    }
    public static int moveCount(int num)
    {
        if(num==1)
        {
            return 2;

        }else
        {
            return moveCount(num-1)*3+2;
        }
    }

}

