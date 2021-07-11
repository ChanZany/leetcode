package com.company.DP;

import java.util.Arrays;

/**
 * @Author ChanZany
 * @Date 2021/7/8 17:10
 * @Version 1.0
01背包问题，内部容量的循环是逆序的，是为了保证每个物品仅被添加一次，而完全背包的物品是可以添加多次的，所以要正序遍历
 */
public class PackageFull {
    int[] W = {1,3,4};
    int[] V = {15,20,30};
    int bagSize = 4;
    void testPackageMulti(){
        int[] dp = new int[bagSize+1];
        for (int i = 0; i < W.length; i++) {
            for (int j = W[i]; j <= bagSize ; j++) {
                dp[j] = Math.max(dp[j],dp[j-W[i]]+V[i]);
                System.out.println(Arrays.toString(dp));
            }

        }
    }

    public static void main(String[] args) {
        PackageFull Main = new PackageFull();
        Main.testPackageMulti();
    }

}
