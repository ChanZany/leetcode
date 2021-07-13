package com.company.DP.base;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * 10->3+3+4->3*3*4=36
 * <p>
 * 1.定义：dp[i]表示拆分数字i可以得到的最大乘积
 * 2.初始：dp[2]=1
 * 3.推导：dp[5]= max(5,max(2*dp[5-2],2*3)) = 6
 * 4.转移：dp[i]=max(dp[i],max(dp[i-j]*j,(i-j)*j)), for j in [1,i-1], 由于拆分j的情况在遍历j的过程中其实都计算过了，所以不拆分j
 * 5.顺序：从前往后
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j) * j));
            }
        }
        return dp[n];
    }
}
