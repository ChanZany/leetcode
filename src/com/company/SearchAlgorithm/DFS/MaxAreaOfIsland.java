package com.company.SearchAlgorithm.DFS;

/**
 * @Author ChanZany
 * @Date 2021/7/5 10:23
 * @Version 1.0
https://leetcode-cn.com/problems/max-area-of-island/solution/dao-yu-de-zui-da-mian-ji-jian-dan-de-di-gui-tu-jie/
 */
public class MaxAreaOfIsland {
    int[] direction = {-1, 0, 1, 0, -1};

    //dfs
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = m > 0 ? grid[0].length : 0;
        int max_area = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    max_area = Math.max(max_area, dfs(grid, i, j));
                }
            }
        }
        return max_area;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (grid[r][c] == 0) return 0;
        grid[r][c] = 0;
        int x, y, area = 1;
        //查找4个方向
        for (int i = 0; i < 4; i++) {
            x = r + direction[i];
            y = c + direction[i + 1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                area += dfs(grid, x, y);
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[][] grid = new int[3][];
        grid[0] = new int[]{1, 0, 1, 1, 0, 1, 0, 1};
        grid[1] = new int[]{1, 0, 1, 1, 0, 1, 1, 1};
        grid[2] = new int[]{0, 0, 0, 0, 0, 0, 0, 1};
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(grid));
    }
}
