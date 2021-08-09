package com.qimo.undo;
import java.util.*;
/*
Description

对给定的n个任务与n个人之间的成本矩阵完成成本最低的任务分配策略。


Input

输入：第一行为用例个数，之后为每一个用例；用例的第一行为任务个数，即n；用例的第二行为使用逗号隔开的人员完成任务的成本；每一个成本描述包括人员序号、任务序号和成本，使用空格隔开。人员序号和任务序号都是从1到n的整数，序号出现的次序没有固定规则。


Output

输出：每一个用例输出一行，从序号为1的人员开始，给出其分配的任务序号，使用空格隔开；使用逗号将多个解隔开。结果按照人员分配的任务序号大小排，第一个人员的任务序号大的放在前面，如果相同则看第二个人员的任务，以此类推。


Sample Input 1

1
4
2 1 6,1 2 2,1 3 7,1 4 8,1 1 9,2 2 4,2 3 3,2 4 7,3 1 5,3 2 8,3 3 1,3 4 8,4 1 7,4 2 6,4 3 9,4 4 4
Sample Output 1

2 1 3 4
* */
public class 分配问题 {



        public static void allSort(String[] str,int pos,ArrayList<String[]> allsort_str){

            if(pos == str.length-1){

                allsort_str.add(str);

            }else{

                for(int i=pos;i<str.length;i ++){

                    String temp = str[pos];

                    str[pos] = str[i];

                    str[i] = temp;

                    allSort(str.clone(),pos+1,allsort_str);

                    str[i] = str[pos];

                    str[pos] = temp;

                }

            }

        }

        public static void main(String[] args) {

            Scanner input = new Scanner(System.in);

            int exampleCount = Integer.parseInt(input.nextLine());

            while(exampleCount-- > 0){

                int size = Integer.parseInt(input.nextLine());

                String[] data = input.nextLine().split(",");

                Integer[][] matrix = new Integer[size][size];

                for(int i=0;i<size*size;i ++){

                    String[] part_data = data[i].split(" ");

                    int m = Integer.parseInt(part_data[0]);

                    int n = Integer.parseInt(part_data[1]);

                    matrix[m-1][n-1] = Integer.parseInt(part_data[2]);

                }

                int num = 1;

                for(int i=size;i>1;i --){

                    num = num*i;

                }

                String[] str = new String[size];

                for(int i=0;i<size;i ++){

                    str[i] = String.valueOf(i);

                }

                ArrayList<String[]> list = new ArrayList<>();

                allSort(str,0,list);

                ArrayList result = new ArrayList<>();

                int mincost = Integer.MAX_VALUE;

                for(int i=0;i<num;i ++){

                    String[] temp = list.get(i);

                    int current = 0;

                    for(int j=0;j<size;j ++){

                        current += matrix[j][Integer.parseInt(temp[j])];

                    }

                    if(mincost > current){

                        mincost = current;

                    }

                }

                int resultnum = 0;

                for(int i=0;i<num;i ++){

                    String[] temp = list.get(i);

                    int current = 0;

                    for(int j=0;j<size;j ++){

                        current += matrix[j][Integer.parseInt(temp[j])];

                    }

                    if(mincost == current){

                        resultnum ++;

                        StringBuffer sb = new StringBuffer();

                        for(int k=0;k<size;k ++){

                            sb.append(temp[k]);

                        }

                        String s = sb.toString();

                        result.add(s);

                    }

                }

                Collections.sort(result);

                for(int i=resultnum-1;i>=0;i --){

                    String output = (String) result.get(i);

                    for(int j=0;j<size;j ++){

                        if(j == size-1){

                            if(i == 0){

                                System.out.print(Integer.parseInt(String.valueOf(output.charAt(j)))+1);

                            }else{

                                System.out.print(Integer.parseInt(String.valueOf(output.charAt(j)))+1+",");

                            }

                        }else{

                            System.out.print(Integer.parseInt(String.valueOf(output.charAt(j)))+1+" ");

                        }
                    }

                }

                System.out.println();


            }
        }

}
