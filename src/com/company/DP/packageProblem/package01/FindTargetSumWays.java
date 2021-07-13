package com.company.DP.packageProblem.package01;

import java.util.Arrays;

/**
 * @Author ChanZany
 * @Date 2021/7/7 21:34
 * @Version 1.0
 */
public class FindTargetSumWays {
    //将nums划分为加法组和减法组，如a=(+)[1,1,1,1]和(-)b=[1],target=3=a-b
    //假定加法的总和为x,那么减法对应的总和就是sum-x
    //x-(sum-x) = target, x = (target+sum)/2，其中target和sum都是定值
    //此时问题转化为从nums中取元素相加为x的取法有多少种
    //即：装满容量为x的背包，有几种方法
    //定义：填满容量为j的背包，有dp[j]种方法
    //转移：dp[j]= dp[j-1](当前取1) + dp[j-2](当前取2)....
    //    简化后为: dp[j] += dp[j-nums[i]], j>=nums[i]
    //初始化：dp[0]=1，装满容量为0的背包，只有一种方法，装0件物品
    //遍历：对于01背包问题，物品(nums)外循环，背包(target)内循环且逆序
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (target>sum) return 0;
        if ((target+sum) % 2 ==1) return 0;
        int bagSize = (target+sum)/2;
        int[] dp = new int[bagSize+1];
        dp[0]=1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i] ; j--) {
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[bagSize];
    }
}
