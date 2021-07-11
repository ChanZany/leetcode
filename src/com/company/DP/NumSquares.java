package com.company.DP;

import java.util.Arrays;

/**给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * @Author ChanZany
 * @Date 2021/7/9 14:56
 * @Version 1.0
 分析：背包为n，物品为可重复选取的完全平方数，求装满背包所需的最少物品数
 定义：装满容量为j的背包，最少所需dp[j]个完全平方数(物品)
 转移：dp[j]=min(dp[j]，dp[j-i*i]+1)
 初值：dp[0]=0, dp[j]=MAX
 遍历顺序：完全背包问题，内外层皆为正序，由于是求最小数，先遍历背包还是先遍历物品都不会影响最小所需物品的数量
 */
public class NumSquares {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,1,dp.length,Integer.MAX_VALUE);
        for (int i = 1; i*i <= n; i++) {   //遍历物品
            for (int j = 1; j <= n; j++) {          //遍历背包
                if (j-i*i>=0)
                    dp[j] = Math.min(dp[j],dp[j-i*i]+1);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumSquares Main = new NumSquares();
        System.out.println(Main.numSquares(4));
    }
}
