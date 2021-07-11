package com.company.DP;

/**
 * @Author ChanZany
 * @Date 2021/7/6 19:54
 * @Version 1.0
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
问总共有多少条不同的路径？

 */
public class UniquePaths {
    //1.定义：dp[i][j]为到达(i,j)点的不同路径个数
    //2.初始: dp[0][0]=0, dp[0][1]=dp[1][0]=1 (只能向右或向下走)
    //3.推导：dp[1][1]=dp[1][0]+dp[0][1]=2, dp[1][2]=dp[0][2]+dp[1][1]
    //4.转移方程：dp[m][n] = dp[m-1][n]+dp[m][n-1]
    //5.遍历顺序，从左上到右下，i++,j++
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][1]=1;
        dp[1][0]=1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
