package com.company.DP.stockProblem;

/**
 * @Author ChanZany
 * @Date 2021/7/10 14:16
 * @Version 1.0
 买卖股票的最佳时机
解法1：贪心
    因为股票只买卖一次，那么贪心的想法自然是取左最小值，取右最大值，那么得到的差值就是最大利润
解法2：动态规划
定义：
    dp[i][0]表示第i天持有股票所得最多现金
    dp[i][1]表示第i天不持有股票所得最多现金
递推：
    第i天持有股票：
        dp[i][0] = max(dp[i-1][0],-price[i])
            - dp[i-1][0]:第i-1天就持有股票，那么就保持现状
            - -prices[i]:第i天买入股票
    第i天不持有股票：
        dp[i][1] = max(dp[i-1][1],prices[i]+dp[i-1][0]);
            - dp[i-1][1]：第i-1天不持有股票，保持现状
            - dp[i-1][0]: 第i-1天持有股票，第i天卖出
 初始化：
    观察递推公式，发现第i天的状态是从第i-1天转换来的
    dp[0][0]=-price[0]; 第0天持有股票，此时持有的股票一定是买入股票了
    dp[0][1]=0;         第0天不持有股票，就是没买呗
 遍历顺序：
    从前往后遍历，现有dp[i-1]再有dp[i]

 */
public class StockTime1 {
    /*贪心思路
    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low,prices[i]);              //取左最小值
            result = Math.max(result,prices[i]-low);    //取最大区间利润
        }
        return result;
    }*/

    public int maxProfit(int[] prices) {
        if (prices.length==0) return 0;
        int [][] dp =new int[prices.length][2];
        dp[0][0] = -prices[0];
//        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);                //当前持有股票
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);       //当前不持有股票
        }
        return dp[prices.length-1][1];
    }

}
