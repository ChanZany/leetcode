package com.company.SearchAlgorithm.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ChanZany
 * @Date 2021/7/5 11:14
 * @Version 1.0
 * <p> https://leetcode-cn.com/problems/pacific-atlantic-water-flow/solution/shui-wang-gao-chu-liu-by-xiaohu9527-xxsx/
 * 虽然题目要求的是满足向下流能到达两个大洋的位置，如果我们对所有的位置进行搜索，那
 * 么在不剪枝的情况下复杂度会很高。因此我们可以反过来想，从两个大洋开始向上流，这样我们
 * 只需要对矩形四条边进行搜索。搜索完成后，只需遍历一遍矩阵，满足条件的位置即为两个大洋
 * 向上流都能到达的位置。
 */
public class PacificAtlanticWaterFlow {
    int[] direction = {-1, 0, 1, 0, -1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights.length == 0 || heights[0].length == 0) return null;
        List<List<Integer>> ans = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        boolean[][] can_reach_p = new boolean[m][n];
        boolean[][] can_reach_a = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(heights, can_reach_p, i, 0);
            dfs(heights, can_reach_a, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            dfs(heights, can_reach_p, 0, i);
            dfs(heights, can_reach_a, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (can_reach_p[i][j] && can_reach_a[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] matrix, boolean[][] can_reach, int r, int c) {
        if (can_reach[r][c]) return;
        can_reach[r][c] = true;
        int x, y;
        for (int i = 0; i < 4; i++) {
            x = r + direction[i];
            y = c + direction[i + 1];
            if (x >= 0 && x < matrix.length
                    && y >= 0 && y < matrix[0].length
                    && matrix[r][c] <= matrix[x][y]) {
                dfs(matrix, can_reach, x, y);
            }
        }

    }


}
