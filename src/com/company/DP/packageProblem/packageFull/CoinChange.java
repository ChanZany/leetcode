package com.company.DP.packageProblem.packageFull;

import java.util.Arrays;

/**
 * @Author ChanZany
 * @Date 2021/7/8 17:21
 * @Version 1.0
 */
public class CoinChange {
    //求coins中有几种方式凑成给定target金额
    //完全背包问题
    //定义：coins中可以凑成j的方式数量为dp[j],题解即为dp[amount]
    //转移：dp[j] += dp[j-coins[i]]; 即当前选择了coins[i],有dp[j-coins[i]]种方法凑出j-coins[i]
    //初始化：dp[0] = 1
    //遍历顺序：由于是求组合数，所以需要外层遍历物品，内层遍历容量
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {          //外层遍历物品
            for (int j = coins[i]; j <= amount; j++) {       //内层遍历容量（正序）
                dp[j] += dp[j - coins[i]];
                System.out.println(Arrays.toString(dp));
            }
        }
        return dp[amount];
    }

    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int j = 1; j <= amount; j++) {       //外层遍历容量   ---变成了全排列
            for (int i = 0; i < coins.length && coins[i] <= j; i++) {          //内层遍历物品
                dp[j] += dp[j - coins[i]];
                System.out.println(Arrays.toString(dp));
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange Main = new CoinChange();
        int amount = 5;
        int[] coins = {1, 2, 5};
        Main.change(amount, coins);
        System.out.println("--------------------------");
        Main.change2(amount, coins);
    }
}
