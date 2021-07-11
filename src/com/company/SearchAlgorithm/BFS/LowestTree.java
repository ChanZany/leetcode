package com.company.SearchAlgorithm.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author ChanZany
 * @Date 2021/7/6 10:52
 * @Version 1.0
 * https://leetcode-cn.com/problems/minimum-height-trees/solution/zui-rong-yi-li-jie-de-bfsfen-xi-jian-dan-zhu-shi-x/
 * 越是靠里面的节点作为根结点越有可能是最小高度树
 * 从边缘开始，先找到所有度为1的节点，然后把所有出度为1的节点进队列，然后不断地bfs，
 * 最后找到的就是两边同时向中间靠近的节点，那么这个中间节点就相当于把整个距离二分了，那么它当然就是到两边距离最小的点啦，也就是到其他叶子节点最近的节点了。
graph:
{
0->3,
1->3,
2->3,
3->[0,1,2,4]
4->[3,5],
5->4
}

queue				res							degree
[0,1,2,5]				[]						[1,1,1,4,2,1]
----------------------------------------------------
for(queue.size)->res.add(cur=queue.poll) for neigbors of cur,degree--(内扩)->if degree[neigbor] == 1-> queue.offer(neigbor)
[1,2,5]					[0]						[1,1,1,4-1,2,1]
[2,5]					[0,1]					[1,1,1,3-1,2,1]
[5]->[5,3]				[0,1,2]					[1,1,1,2-1,2,1]
[3]->[3,4]				[0,1,2,5]				[1,1,1,2-1,2-1,1]
for结束
-----------------------------------------------
for(queue.size)->res.add(cur=queue.poll)		for neigbors of cur,degree--(内扩)
[3,4]->[4]				[3] 					[0,0,0,1,0,1]
[4]->[]					[3,4]					[0,0,0,0,0,0]
for结束
----------------------------------------
可见res会保存当前图的的外围节点
 */
public class LowestTree {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n==1){
            res.add(0);
            return res;
        }
        //建立各个节点的度表
        int[] degree = new int[n];
        //建立图关系<cur,[from]>
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        //对建立的图，从边缘开始进行BFS
        Queue<Integer> queue = new LinkedList<>();
        //将边缘节点入队
        for (int i = 0; i < n; i++) {
            if (degree[i]==1) queue.offer(i);
        }
        while (!queue.isEmpty()){
            /*这个地方注意，我们每层循环都要new一个新的结果集合，这样最后保存的就是最终的最小高度树了*/
            res = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                res.add(cur);
                List<Integer> neighbors = graph.get(cur);
                for (Integer neighbor : neighbors) {
                    degree[neighbor]--;
                    if (degree[neighbor]==1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LowestTree Main = new LowestTree();
        int[][] edge = new int[5][];
        edge[0] = new int[]{3,0};
        edge[1] = new int[]{3,1};
        edge[2] = new int[]{3,2};
        edge[3] = new int[]{3,4};
        edge[4] = new int[]{5,4};
        List<Integer> res = Main.findMinHeightTrees(6, edge);
        res.forEach(System.out::println);
    }
}
