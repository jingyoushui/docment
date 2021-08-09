package com.qimo.undo;
/*
Description

Given two array A1[] and A2[], sort A1 in such a way that the relative order among the elements will be same as those in A2. For the elements not present in A2. Append them at last in sorted order. It is also given that the number of elements in A2[] are smaller than or equal to number of elements in A1[] and A2[] has all distinct elements.

Input:A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8} A2[] = {2, 1, 8, 3}Output: A1[] = {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9}

Since 2 is present first in A2[], all occurrences of 2s should appear first in A[], then all occurrences 1s as 1 comes after 2 in A[]. Next all occurrences of 8 and then all occurrences of 3. Finally we print all those elements of A1[] that are not present in A2[]

Constraints:1 ≤ T ≤ 501 ≤ M ≤ 501 ≤ N ≤ 10 & N ≤ M1 ≤ A1[i], A2[i] ≤ 1000


Input

The first line of input contains an integer T denoting the number of test cases. The first line of each test case is M and N. M is the number of elements in A1 and N is the number of elements in A2.The second line of each test case contains M elements. The third line of each test case contains N elements.


Output

Print the sorted array according order defined by another array.
Sample Input 1

1
11 4
2 1 2 5 7 1 9 3 6 8 8
2 1 8 3
Sample Output 1

2 2 1 1 8 8 3 5 6 7 9
* */
//leetcode   1122
/*    作者：nuan
            链接：https://leetcode-cn.com/problems/relative-sort-array/solution/java-chuang-jian-yi-ge-mapji-lu-arr1zhong-de-zhi-d/
            来源：力扣（LeetCode）
            著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
            */

import java.util.Scanner;



public class 按照另一个数组排序 {
    //显示数组
    public static void displayArr(int[] a)
    {
        for (int con: a
        ) {
            System.out.print(con+" ");
        }
        System.out.println();
    }
    //光标从本行头开始，从键盘输入一串数字(在一行，以空格隔开)后生成数组，光标返回到下一行的开始
    public static int[] setIntArrayWithInoutLine(Scanner sc)
    {
        // Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toString();
        String[] arr  = str.split(" ");
        int[] b = new int[arr.length];
        for(int j = 0; j<b.length;j++) {
            b[j] = Integer.parseInt(arr[j]);
        }
        return b;
    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] arr = new int[1001];   //由于题目说arr1的范围在0-1000，所以生成一个1001大小的数组用来存放每个数出现的次数。
        int[] ref = new int[arr1.length];  //储存答案的数组。

        for(int i = 0; i < arr1.length; i++) { // 遍历arr1，把整个arr1的数的出现次数储存在arr上，arr的下标对应arr1的值，arr的值对应arr1中值出现的次数。
            arr[arr1[i]]++;  //如果遇到了这个数，就把和它值一样的下标位置上+1，表示这个数在这个下标i上出现了1次。
            //arr[arr1[i]]  其实就是表示arr1中的元素（arr1[i]）出现的次数
        }

        int cnt = 0;  //最终答案数组的下标
        for(int i = 0; i < arr2.length; i++) {  //遍历arr2，现在开始要输出答案了。
            while(arr[arr2[i]] > 0) {   //如果arr2的值在arr所对应的下标位置出现次数大于0，那么就说明arr中的这个位置存在值。
                ref[cnt++] = arr2[i];  //如果存在值，那就把它加到ref中，因为要按arr2的顺序排序。从arr2的0下标开始，保证了按照arr2中的顺序。
                arr[arr2[i]]--;         //加进去了次数 -1 ，不然就死循环了。
            }
        }

        for(int i = 0; i < 1001; i++) {  // 如果arr1的值不在arr2中，那么不能就这么结束了，因为题目说了如果不在，剩下的值按照升序排序。
            while(arr[i] > 0) {   //同样也是找到大于0的下标（现在arr[i] > 0说明不是arr1中的元素），然后一直加到ref中，直到次数为0。
                ref[cnt++] = i;  //这个i就是arr1[]中元素的值，因为前面：arr[arr1[i]]++; 并且这样添加就是有序的
                arr[i]--;  //加进去了次数 -1 ，不然就死循环了。
            }
        }
        return ref;  //返回最终答案。
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        while(count>0)
        {
            String s = scanner.nextLine();
            String[] strs = s.split(" ");
            int[] arr1 = setIntArrayWithInoutLine(scanner);
            int[] arr2 = setIntArrayWithInoutLine(scanner);
            displayArr(relativeSortArray(arr1,arr2));
            count--;
        }
    }
}
