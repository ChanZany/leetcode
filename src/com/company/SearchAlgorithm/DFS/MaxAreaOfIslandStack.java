package com.company.SearchAlgorithm.DFS;

import javafx.util.Pair;

import java.util.Stack;

/**
 * @Author ChanZany
 * @Date 2021/7/5 10:23
 * @Version 1.0
 */
public class MaxAreaOfIslandStack {
    int[] direction = {-1, 0, 1, 0, -1};

    //dfs
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = m > 0 ? grid[0].length : 0;
        int area = 0;
        int local_area, x, y;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    local_area = 1;
                    grid[i][j] = 0;
                    Stack<Pair<Integer,Integer>> island = new Stack<>();
                    island.push(new Pair<>(i,j));
                    while (!island.isEmpty()){
                        Pair<Integer, Integer> peek = island.pop();
                        int r = peek.getKey();
                        int c = peek.getValue();
                        for (int k =0 ;k<4;k++){
                            x = r+direction[k];
                            y = c+direction[k+1];
                            if (x>=0 && x<m && y>=0 && y<n && grid[x][y]==1){
                                grid[x][y] = 0;
                                local_area++;
                                island.push(new Pair<>(x,y));
                            }
                        }
                    }
                    area = Math.max(local_area,area);
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[][] grid = new int[3][];
        grid[0] = new int[]{1, 0, 1, 1, 0, 1, 0, 1};
        grid[1] = new int[]{1, 0, 1, 1, 0, 1, 1, 1};
        grid[2] = new int[]{0, 0, 0, 0, 0, 0, 0, 1};
        System.out.println(new MaxAreaOfIslandStack().maxAreaOfIsland(grid));
    }
}
