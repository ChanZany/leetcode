package com.company.DP;

/**买卖股票的最佳时机含手续费
 你可以⽆限次地完成交易，但是你每笔交易都需要付⼿续费
 【无手续费】
 dp[i][j]表示第i天的股票状态为j
 第i天持有股票:dp[i][0]=max(dp[i-1][0],dp[i-1][1]-prices[i])
 第i天不持有股票：dp[i][1] = max(dp[i-1][1],dp[i-1][0]+price[i])
 【有手续费】
 第i天持有股票:dp[i][0]=max(dp[i-1][0],dp[i-1][1]-prices[i])
 第i天不持有股票：dp[i][1] = max(dp[i-1][1],dp[i-1][0]+price[i]-fee[i])

 */
public class StockTime6 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n==0) return 0;
        int[][]dp = new int[n][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);       //持有
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i]-fee);   //不持有
        }
        return dp[n-1][1];
    }
}
