package com.company.DP.stockProblem;

/**
 你最多可以完成两笔交易。
本题的难点在于至多买卖两次，这意味者可以买卖一次，可以买卖两次，也可以不买卖
 【状态定义】
    一天一共有五种状态
        0：没有操作
        1：第一次买入
        2：第一次卖出
        3：第二次买入
        4：第二次卖出
    dp[i][j]表示第i天状态j所剩最大现金
 【递推公式】
    dp[i][1] = max(dp[i-1][0]-prices[i],dp[i-1][1])
        1. 第i天买入股票，dp[i][1] = dp[i-1][0]-prices[i]
        2. 第i天没有操作，dp[i][1] = dp[i-1][1]
    dp[i][2] = max(dp[i-1][1]+prices[i],dp[i-1][2])
        1. 第i天卖出股票：dp[i][2] = dp[i-1][1]+prices[i]
        2. 第i天没有操作，dp[i][2] = dp[i-1][2]
 同理可以退出剩下状态转移
    dp[i][3] = max(dp[i-1][2]-prices[i],dp[i-1][3])
    dp[i][4] = max(dp[i-1][3]+prices[i],dp[i-1][4])
 【初始化】
    第0天没有操作，dp[0][0]=0
    第0天做第一次买入的操作：dp[0][1] = -prices[0]
    第0天做第一次卖出的操作：dp[0][2] = 0
    第0天做第二次买入的操作：dp[0][3] = -prices[0]
    第0天做第二次卖出的操作：dp[0][4] = 0
 */
public class StockTime3 {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int[][] dp = new int[prices.length][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i-1][0];
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);
            dp[i][3] = Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
            dp[i][4] = Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
        }

        return dp[prices.length-1][4];
    }
}
