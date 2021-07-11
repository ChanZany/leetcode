package com.company.SearchAlgorithm.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author ChanZany
 * @Date 2021/7/5 16:29
 * @Version 1.0
 * <p>
 * 本题实际上是求两个岛屿间的最短距离，因此我们可以先通过任意搜索方法找到其中一个岛
 * 屿，然后利用广度优先搜索，查找其与另一个岛屿的最短距离。
 * https://leetcode-cn.com/problems/shortest-bridge/solution/duo-yuan-dfskuo-san-sou-suo-by-falseblan-td4u/
 */
public class ShortestBridge {

    private int[] d = {-1, 0, 1, 0, -1};

    private static class pair<K, V> {
        K x;
        V y;
        public pair(K x, V y) {
            this.x = x;
            this.y = y;
        }
    }

    public int shortestBridge(int[][] grid) {
        int m = grid.length, n = m > 0 ? grid[0].length : 0;
        // dfs寻找第一个岛屿，并把1全部赋值为2
        Queue<pair<Integer, Integer>> points = new LinkedList<>();
        boolean flipped = false;    //控制dfs只找第一个岛屿
        for (int i = 0; i < m; i++) {
            if (flipped) break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(points, grid, m, n, i, j);
                    flipped = true;
                    break;
                }
            }
        }
        // bfs从第一个岛屿中任一点开始，寻找第二个岛屿，并把过程中经过的0赋值为2
        int x,y;
        int level = 0;
        while (!points.isEmpty()){
            level++;
            //多起点的BFS，需要按层(多点同时)进行扩展
            int n_points = points.size();
            while (n_points-- > 0){
                pair<Integer, Integer> poll = points.poll();
                int r = poll.x, c = poll.y;
                for (int k = 0; k < 4; k++) {
                    x = r+d[k];
                    y = c+d[k+1];
                    if (x>=0 && y>=0 && x<m && y<n){
                        if (grid[x][y]==2) continue;
                        if (grid[x][y]==1) return level;        //说明找到了第二个岛屿
                        points.add(new pair<>(x,y));
                        grid[x][y] = 2;
                    }
                }
            }
        }
        return 0;
    }

    private void dfs(Queue<pair<Integer, Integer>> points, int[][] grid, int m, int n, int i, int j) {
        if (grid[i][j] == 0) {
            points.add(new pair<>(i, j));
            return;
        }
        grid[i][j] = 2;
        int x, y;
        for (int k = 0; k < 4; k++) {
            x = i + d[k];
            y = j + d[k + 1];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 2) {
                dfs(points, grid, m, n, x, y);
            }
        }
    }

    public static void main(String[] args) {
        ShortestBridge Main = new ShortestBridge();
        int[][] grid = new int[5][];
        grid[0] = new int[]{1,1,1,1,1};
        grid[1] = new int[]{1,0,0,0,1};
        grid[2] = new int[]{1,0,1,0,1};
        grid[3] = new int[]{1,0,0,0,1};
        grid[4] = new int[]{1,1,1,1,1};
        System.out.println(Main.shortestBridge(grid));
    }
}
