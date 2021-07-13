package com.company.DP.packageProblem.packageFull;

import java.util.Arrays;

/**编写一个函数来计算可以凑成总金额【所需的最少的硬币个数】。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * @Author ChanZany
 * @Date 2021/7/9 13:39
 * @Version 1.0
 定义：凑出j数目金额所需的最少硬币个数为dp[j]
 转移：dp[j]=min(dp[j],dp[j-coins[i]]+1)
 初始化：dp[j]=Integer.MAX_VALUE, dp[0]=0
 遍历顺序：求最少所需硬币个数，那么钱币有顺序和没有顺序都不会影响所需硬币的最小个数
 例子：
 coins = [1, 2, 5], amount = 5
 当前可选物品只有coins[0]=1
 dp[0]=0, dp[1]=min(MAX,dp[1-1]+1)=1,dp[2]=min(MAX,dp[2-1]+1)=2, dp[3]=min(MAX,dp[3-1]+1)=3,dp[4]=4,dp[5]=5
当前可选物品只有coins[0:1]=[1,2]
 dp[0]=0, dp[1]=min(1,dp[1-2]+1)=1,dp[2]=min(2,dp[0]+1)=1, dp[3]=min(3,dp[1]+1)=2, dp[4]=min(4,dp[2]+1)=2, dp[5]=min(5,dp[3]+1)=3
当前可选物品只有coins[0:2]=[1,2,5]
 dp[0]=0, dp[1]=min(1,dp[1-5]+1)=1,dp[2]=min(1,dp[-2]+1)=2, dp[3]=min(2,dp[-2]+1)=2,dp[4]=min(2,dp[-1]+1)=2,dp[5]=min(3,dp[0]+1)=1
 所以dp=[0,1,2,2,2,1]
 */
public class CoinChange2 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,1,dp.length,Integer.MAX_VALUE);
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j-coins[i]]==Integer.MAX_VALUE) continue;
                dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }
        if(dp[amount]==Integer.MAX_VALUE) return -1;
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange2 Main = new CoinChange2();
        int[] coins = {2};
        System.out.println(Main.coinChange(coins, 3));
    }

}
