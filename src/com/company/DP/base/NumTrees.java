package com.company.DP.base;

/**
 * @Author ChanZany
 * @Date 2021/7/7 9:17
 * @Version 1.0
  不同的二叉搜索树数目
 */
public class NumTrees {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumTrees Main = new NumTrees();
        System.out.println(Main.numTrees(3));
    }
}
