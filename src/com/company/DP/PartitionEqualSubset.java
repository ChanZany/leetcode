package com.company.DP;

import java.util.Arrays;

/**
 * @Author ChanZany
 * @Date 2021/7/7 20:05
 * @Version 1.0
 */
public class PartitionEqualSubset {
    //背包问题：target为sum/2
    //dp[j]:容量为j的背包，以最大化装进物品的价值为目标，得到的最优解，
    //物品: i=0,..,nums.length, W[i]=nums[i], V[i]=nums[i]
    //以nums=[1,5,11,5]为例，推导：dp[0]=0,dp[1]=1....dp[4]=1,dp[5]=5,dp[6]=6..dp[10]=10,dp[11]=11 -> 得到特性:dp[j]<=j
    //转移方程：dp[j] = max(dp[j],dp[j-W[i]]+V[i]),
    // j表示容量，从0开始遍历到题目给定上限200*100, 由特性可知,j取[nums[i],target+1]即可找到目标值
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        System.out.println(sum);
        int target = sum / 2;
        int[] dp = new int[target + 1];
        //外层循环物品，内层循环容量(逆序)
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        //背包内的物品价值恰好可以凑到target，则说明dp[target]==target
        if (dp[target] == target) return true;
        return false;
    }

    public static void main(String[] args) {
        PartitionEqualSubset Main = new PartitionEqualSubset();
        int[] nums = {2, 2, 1, 1};
        System.out.println(Main.canPartition(nums));
    }
}
