package com.company.DP;

/**
 最多可以完成k笔交易
 定义：
    第i的状态是j，所剩下的最大现金是dp[i][j]
    j的取值范围为：
        0：不操作
        1：第一次买入
        2：第一次卖出
        3：第二次买入
        4：第二次卖出
        ...
    除了0之外，偶数就是卖出，奇数就是买入
    最多有k笔交易，则j的范围定义为2*k+1即可
 递推：
    dp[i][1]= max(dp[i-1][1],dp[i-1][0]-prices[i])
    dp[i][2]= max(dp[i-1][2],dp[i-1][1]+prices[i])
    ...
    for j=0; j<2*k-1; j+=2
    dp[i][j+1]=max(dp[i-1][j+1],dp[i-1][j]-prices[i])
    dp[i][j+2]=max(dp[i-1][j+2],dp[i-1][j+1]+prices[i])
 初始化：
    dp[0][0] = 0
    for j=1;j<2*k;j+=2
    dp[0][j] = -prices[0]
 遍历顺序：
    从前往后，dp[i]<-dp[i-1]
 */
public class StockTime4 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length==0) return 0;
        int[][] dp = new int[prices.length][2*k+1];
        //初始化
        for (int j = 1; j < 2*k; j+=2) {
            dp[0][j] = -prices[0];
        }
        //递推状态转移，前向
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 2 * k - 1; j+=2) {
                dp[i][j+1] = Math.max(dp[i-1][j+1], dp[i-1][j]-prices[i]);      //当前为买入状态
                dp[i][j+2] = Math.max(dp[i-1][j+2], dp[i-1][j+1]+prices[i]);    //当前为卖出状态
            }
        }
        return dp[prices.length-1][2*k];
    }
}
