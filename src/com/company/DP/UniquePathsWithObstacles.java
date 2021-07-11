package com.company.DP;

/**
 * @Author ChanZany
 * @Date 2021/7/6 20:20
 * @Version 1.0
 * <p>
 * 前面分析了没有障碍的情况，有障碍的话，其实就是标记对应的dp表保存初始值0就可以了
 * 1. dp[i][j]表示从(0,0)出发，到(i,j)的不同路径数
 * 2. dp[i][j] = dp[i-1][j] + dp[i][j-1], 如果遇到障碍就保存初始状态
      if(obstacleGrid[i][j]==0){  //当(i,j)没有障碍的时候，再推导dp[i][j]
      dp[i][j] = dp[i-1][j] + dp[i][j-1]
      }
 * 3. dp[i][0]和dp[0][j]在遇到障碍前皆为1，遇到后皆为0
 * for(int i=0;i<m && obstacleGrid[i][0]==0 ;i++) dp[i][0] = 1;
 * for(int j=0;j<n && obstacleGrid[0][j]==0 ;j++) dp[0][j] = 1;
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) dp[i][0] = 1;
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) dp[0][j] = 1;
        for(int i = 1; i < m; i++){
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j]==0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
