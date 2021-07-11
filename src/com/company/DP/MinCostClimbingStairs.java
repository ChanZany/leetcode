package com.company.DP;

/**
 * @Author ChanZany
 * @Date 2021/7/6 18:47
 * @Version 1.0
 */
public class MinCostClimbingStairs {
    //题目：没当你爬上一个阶梯都要花费对应的体力值
    //1.定义：dp[i]表示爬到第i个阶梯的最低花费
    //2.初始化：dp[0]=0,dp[1]=0
    //3.例子：dp[2]=min(dp[0]+cost[2],dp[1]+cost[2]),dp[3]= min(dp[2]+cost[2],dp[1]+cost[1])
    //4.转移方程：dp[i] = min(dp[i-1],dp[i-2])+cost[i]
    //5.遍历顺序：从前往后
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n < 2) return 0;
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
             dp[i] = Math.min(dp[i-2],dp[i-1])+cost[i];
        }

        return dp[n];
    }
}
