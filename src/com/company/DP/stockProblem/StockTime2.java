package com.company.DP.stockProblem;

/**
 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 这个题目和买卖股票的最佳时机1唯一区别在于股票可以买卖多次
 解法与前面的区别在于递推公式变了
 递推：
    第i天持有股票:dp[i][0]=max(dp[i-1][0],dp[i-1][1]-prices[i])
        - dp[i-1][0]：第i-1天就持有该股票，保持现状
        - do[i-1][1]-prices[i]：第i-1天没有持有股票，说明是第i天买入了这只股票
        在StockTime1中，因为股票全程只能买卖一次，如果买入股票，那么第i天持有股票即dp[i][0]一定就是-prices[i]
        而本题，因为一只股票可以买卖多次，所以当第i天买入股票的时候，所持有的现金可能有之前买卖过的利润，即dp[i][0] = dp[i][1]-prices[i]
    第i天不持有股票：dp[i][1] = max(dp[i-1][1],dp[i-1][0]+price[i])
        - dp[i-1][1]：第i-1天不持有股票，保持现状
        - dp[i-1][0]: 第i-1天持有股票，第i天卖出

 */
public class StockTime2 {

    public int maxProfit(int[] prices) {
        if (prices.length==0) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return dp[prices.length-1][1];
    }
}
