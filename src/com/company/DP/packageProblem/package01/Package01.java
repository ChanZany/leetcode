package com.company.DP.packageProblem.package01;

import java.util.Arrays;

/**
 * @Author ChanZany
 * @Date 2021/7/7 9:28
 * @Version 1.0
 * N件物品和一个承重为W的背包，第i件物品的重量是wight[i],价值是value[i],每件物品只能用【1】次，求解将哪些物品装入背包里物品价值最大
 * 1.定义：dp[i][j]表示前i件物品恰放入容量为j的背包可以获得的最大的价值总和
 * 2.转移方程：dp[i][j] = max( dp[i-1][j], dp[i-1][j-weight[i]]+value[i] )
 *                           不放第i件物品             放入第i件物品
 * 3.初始化：
 * dp[0][j] = dp[0][j-weight[0]] + value[0]，原因：此时可选的物品只有0，要使背包内价值最大，就被物品0装入背包(容量j>weight[0])
 * dp[i][0]=0，原因：此时背包容量为0，无法装下任何物品，所以背包内价值为0
 */
public class Package01 {
    int[] weight = {1, 3, 4};
    int[] value = {15, 20, 30};
    int bag = 4;

    public void bagProblem1() {
        //dp定义
        int[][] dp = new int[weight.length][bag + 1];
        //初始化
        for (int j = bag; j >= weight[0]; j--) {
            dp[0][j] = dp[0][j - weight[0]] + value[0];
        }
        //weight数组的大小，就是物品个数
        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j <= bag; j++) {
                if (j < weight[i]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
            }
        }
        for (int[] dpi : dp) {
            System.out.println(Arrays.toString(dpi));
        }
    }

    //滚动数组-压缩为一维
    public void bagProblem2() {
        int[] dp = new int[bag + 1];  //dp[j]表示背包容量为j时可获得的最大价值
        for (int i = 0; i < weight.length; i++) {
            for (int j = bag; j >= weight[i]; j--) {    //递减顺序计算,i=0时，从后往前遍历初始化dp。i=1..weight.length时，从后往前遍历计算
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
    }

    public static void main(String[] args) {
        Package01 Main = new Package01();
        Main.bagProblem2();
    }
}
