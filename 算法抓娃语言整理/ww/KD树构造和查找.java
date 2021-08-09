package com.qimo.undo;


import java.util.*;

/*
KD树构造和查找
Description

对给定的点集合构造KD树，要求如下：将方差最大的维度作为当前的分割维度，将数据集在分割维度上排序后的中位数作为分割点。程序要检索给定点对应的最近的K个点的坐标。


Input

输入第一行为测试用例个数，后面为测试用例，每一个用例包含三行，第一行为点集合（点之间用逗号隔开，两个坐标用空格隔开），第二行为检索的点，第三行为K值。


Output

输出每一个用例的最近K个点，按照距离从小到大的顺序打印。


Sample Input 1

1
3 5,6 2,5 8,9 3,8 6,1 1,2 9
8.2 4.6
2
Sample Output 1

8 6,9 3
* */
public class KD树构造和查找 {

    public static class Node {
        double[] val;
        int dimension;
        Node left;
        Node right;

        Node (double[] val) {
            this.val = val.clone();
            left = null;
            right = null;
        }

        public int getDimensionNum() {
            return val.length;
        }

        public int getDimension() {
            return dimension;
        }

        public void setDimension(int dimension) {
            this.dimension = dimension;
        }

        public double getVal (int n) {
            return val[n];
        }

        public String toString() {
            return Arrays.toString(val);
        }

    }

    /**
     * KD树的构造方法
     * @params: [nodes]
     * @return: contest3.N2_KDTree.Node
     * @time: 2019/11/22 16:10
     */
    public static Node KDTree (List<Node> nodes) {

        /** 构造KD树的递归终止条件 */
        //System.out.println("len:" + nodes.size() + " : " + nodes.toString());
        if (nodes.size() == 0)
            return null;
        if (nodes.size() == 1)
            return nodes.get(0);
        /** 找分割维度(方差最大的维度)，用divideDimension记录 */
        int dimensionCount = nodes.get(0).getDimensionNum();
        int nodesCount = nodes.size();
        int cuttingDimension = -1;
        int maxVariance = -1;
        for (int i = 0 ; i < dimensionCount; i++) {
            int average = 0;
            for (int j = 0; j < nodesCount; j++) {
                average += nodes.get(j).getVal(i);
            }
            average /= nodesCount;
            int variance = 0;
            for (int j = 0; j < nodesCount; j++) {
                variance += Math.pow(nodes.get(j).getVal(i) - average, 2);
            }
            variance /= nodesCount;
            if (variance > maxVariance) {
                maxVariance = variance;
                cuttingDimension = i;
            }
        }
        /** 构造KD树，递归主方法 */
        int n = cuttingDimension;    //需确定一个final值，采取重构造方法
        nodes.sort(Comparator.comparingDouble(node -> node.getVal(n)));
        // 对list进行自定义排序：lambda表达式写法
        //System.out.println("排序后：" + nodes.toString());
        Node root = nodes.get(nodesCount / 2);
        root.setDimension(n);
        //System.out.println("root : " + root.toString());
        List<Node> nodesL = nodes.subList(0, nodesCount / 2);
        root.left = KDTree(nodesL);
        List<Node> nodesR = nodes.subList(nodesCount / 2 + 1, nodesCount);
        root.right = KDTree(nodesR);
        return root;

    }

    /**
     * KD树查找k个最近点
     * @params: [root, target, n]
     * @return: java.util.List<contest3.N2_KDTree.Node>
     * @time: 2019/11/22 16:09
     */
    public static List<Node> search (Node root, Node target, int k) {

        Map<Node, Double> node_distMap = new HashMap<>();
        PriorityQueue<Node> maxHeap = new PriorityQueue<>(k, new Comparator<Node>() {
            @Override
            // 重载成按distMap里存储的距离进行排序的最大堆
            public int compare(Node o1, Node o2) {
                if (node_distMap.get(o2) - node_distMap.get(o1) > 0)
                    return 1;
                else if (node_distMap.get(o2) - node_distMap.get(o1) < 0)
                    return -1;
                else
                    return 0;
            }
        });
        double[] targetVal = target.val;
        Stack<Node> find = new Stack<>();
        /** 先深入遍历一条分支至叶节点，并全程压栈 */
        while (root != null) {
            find.push(root);
            int d = root.getDimension();
            if (targetVal[d] <= root.val[d])
                root = root.left;
            else
                root = root.right;
        }
        /** 递归回溯，在回溯过程中判断是否应进入某节点的另一分支进行DFS */
        while (!find.isEmpty()) {
            Node p = find.pop();
            /** 用k最大堆判断p节点距离是否符合结果要求 */
            int d = p.getDimension();
            double dist = Math.sqrt(Math.pow(target.getVal(0) - p.getVal(0), 2) + Math.pow(target.getVal(1) - p.getVal(1), 2));
            node_distMap.put(p, dist);  // 所有遍历过的节点的距离信息都记录入map
            if (maxHeap.size() < k)
                maxHeap.offer(p);
            else if (maxHeap.size() == k && dist < node_distMap.get(maxHeap.peek())) {
                maxHeap.poll();
                maxHeap.offer(p);
            }
            /** 断是否应该检索p的另一边子树 */
            if (node_distMap.get(maxHeap.peek()) > Math.abs(target.getVal(d) - p.getVal(d))) {
                // 若当前第k近距离大于target节点到p节点的维度距离，则应检查另一边子树
                if (node_distMap.containsKey(p.left))
                    // 判断哪边子树是未检查过的
                    find.push(p.right);
                else
                    find.push(p.left);
                /** 检查该分支，则深入该分支至叶节点,全程压栈 */
                p = find.pop();
                while (p != null) {
                    find.push(p);
                    d = p.getDimension();
                    if (targetVal[d] <= p.val[d])
                        p = p.left;
                    else
                        p = p.right;
                }
            }

        }
        List<Node> result = new ArrayList<>();
        //System.out.println("size" + maxHeap.size());
        while (maxHeap.size() > 0) {
            //System.out.println(maxHeap.peek().toString() + "的距离：" + node_distMap.get(maxHeap.peek()));
            result.add(0, maxHeap.poll());
        }
        return result;

    }

    /**
     * KD树的打印方法
     * @params: [root]
     * @return: void
     * @time: 2019/11/22 16:10
     */
    public static void printKDTree (Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node printNode = queue.poll();
            System.out.println(Arrays.toString(printNode.val));
            if (printNode.left != null)
                queue.offer(printNode.left);
            if (printNode.right != null)
                queue.offer(printNode.right);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rounds = Integer.valueOf(scan.nextLine());
        for (int i = 0; i < rounds; i++) {
            List<Node> nodeList = new ArrayList<>();
            String nodesLine = scan.nextLine();
            String targetLine = scan.nextLine();
            int n = Integer.valueOf(scan.nextLine());

            String[] nodes = nodesLine.split(",");
            for (int j = 0; j < nodes.length; j++) {
                String[] nodeStr = nodes[j].split(" ");
                double[] nodeVal = new double[2];
                for (int k = 0; k < 2; k++) {
                    nodeVal[k] = Double.valueOf(nodeStr[k]);
                }
                Node node = new Node(nodeVal);
                nodeList.add(node);
            }
            String[] targetStr = targetLine.split(" ");
            double[] targetVal = new double[2];
            for (int k = 0; k < 2; k++) {
                targetVal[k] = Double.valueOf(targetStr[k]);
            }
            Node target = new Node(targetVal);
            List<Node> result = search(KDTree(nodeList), target, n);
            for (int j = 0; j < result.size() - 1; j++) {
                System.out.printf((result.get(j).getVal(0) + " " + result.get(j).getVal(1) + ",").replaceAll("\\.0", ""));
            }
            System.out.println((result.get(result.size() - 1).getVal(0) + " " + result.get(result.size() - 1).getVal(1)).replaceAll("\\.0", ""));
        }

    }


}
