package com.qimo.undo;
/*
Description

Babul’s favourite number is 17. He likes the numbers which are divisible by 17. This time what he does is that he takes a number N and tries to find the largest number which is divisible by 17, by rearranging the digits. As the number increases he gets puzzled with his own task. So you as a programmer have to help him to accomplish his task.Note: If the number is not divisible by rearranging the digits, then print “Not Possible”. N may have leading zeros.


Input

The first line of input contains an integer T denoting the no of test cases. Each of the next T lines contains the number N.


Output

For each test case in a new line print the desired output.


Sample Input 1

4
17
43
15
16
Sample Output 1

17
34
51
Not Possible
* */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 数字重组整除问题 {
    //'7,4,1,8,5,2,9,6,3,0'
    static int max = 0;

    public static String LargestNumber(String x) {
        max = 0;
        List<Integer> num = new ArrayList<>();
        for (int i = 0; i < x.length(); i++) {
            num.add(x.charAt(i) - '0');
        }
        //for (Integer xx : num)
        //System.out.println(xx);
        for (int i = 0; i < num.size(); i++) {
            StringBuilder s = new StringBuilder();
            s.append(num.get(i));
            List<Integer> numm = new ArrayList<>(num);
            numm.remove(i);
            //System.out.println("s=" + s.toString() + "num.size="+num.size());
            getResult(s, numm);
        }
        if (max == 0)
            return "Not Possible";
        return String.valueOf(max * 17);
    }

    public static void getResult(StringBuilder s, List<Integer> num) {
        //System.out.println("一趟"+s.toString());
        if (num.size() == 0) {
            int number = Integer.valueOf(s.toString());
            //System.out.println("number=" + number);
            if (number % 17 == 0 && number / 17 > max)
                max = number / 17;
            return;
        }
        else {
            for (int i = 0; i < num.size(); i++) {
                StringBuilder ss = new StringBuilder(s);
                List<Integer> numm = new ArrayList<>(num);
                ss.append(numm.remove(i));
                getResult(ss, numm);
            }
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rounds = Integer.valueOf(scan.nextLine());
        for (int i = 0; i < rounds; i++) {
            String line = scan.nextLine();
            System.out.println(LargestNumber(line));
        }

    }
}