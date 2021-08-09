package com.qimo.undo;
/*
Description

给定有向无环图中所有边，计算图的拓扑排序解的个数。


Input

输入第一行为用例个数，后面每一行表示一个图中的所有边，边的起点和终点用空格隔开，边之间使用逗号隔开。


Output

输出拓扑排序解的个数。


Sample Input 1

1
a c,b c,c d,d e,d f,e g,f g
Sample Output 1

4
* */


import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 拓扑排序解的个数 {
    static Scanner in = new Scanner(System.in);
    static int[][] mp = new int[500 + 5][500 + 5];
    static int n = 0, cnt = 0, ans = 0, t = 0, c = 0;
    static int[] deleteEdgs = new int[500 + 5];
    static int[] topo = new int[500 + 5];
    static int[] indegree = new int[500 + 5];
    static int[] a = new int[500 + 5];
    /**
     * mp图的邻接矩阵
     * deleteEdgs删除的边=》控制变量cnt
     * indegree统计顶点的入度
     * a存储入度为零点的数组=>变量c
     * */
    static void toposort(int i) {
        if (i>=n) {// 不存在入度数为零的边了
            ans++;
//			for (int j = 0; j <n; j++)
//				System.out.print(topo[j]+" ");
//			System.out.println();
        } else {
            int te = 0, pre = 0,prec=0;
            for (int p = 0; p < c; p++) {
                te = a[p];
                topo[i]=te;//将顶点插入topo序列
                if (a[p] != -1){
                    a[p] = -1;// 移除顶点
                    pre = cnt;prec = c;//保存被删除的边和顶点的位置信息
                    for (int j = 0; j < n; j++) {
                        if (mp[te][j] == 1) {
                            deleteEdgs[cnt++] = j;// 保存删除的边
                            mp[te][j] = 0;// 去掉边
                            indegree[j]--;
                            if (indegree[j] == 0)//调整
                                a[c++]=j;
                        }
                    }
                    toposort(i + 1);
                    //回溯，即上面的反操作。
                    a[p] = te;// 点恢复
                    for (int j = pre; j < cnt; j++) {
                        mp[te][deleteEdgs[j]] = 1;
                        indegree[deleteEdgs[j]]++;
                    }
                    cnt-=(cnt-pre);//边位置信息
                    c-=(c-prec);//点位置信息
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) {
                n = 0;ans = 0;
                cnt = 0;c = 0;
                Arrays.fill(indegree, 0);
                in.nextLine();
                Set<Integer> vetex = new HashSet<>();
                String[] edgs = in.nextLine().split(",");
                int x, y, i, j;
                for (i = 0; i < edgs.length; i++) {
                    String[] v = edgs[i].split(" ");
                    x = v[0].charAt(0) - 97;
                    y = v[1].charAt(0) - 97;
                    vetex.add(x);vetex.add(y);
                    mp[x][y] = 1;//建图
                    indegree[y]++;//
            }
            n = vetex.size();
            for (i = 0; i < n; i++) {
                if (indegree[i] == 0)
                    a[c++] = i;
            }
            toposort(0);
            System.out.println(ans);
        }
    }
}
