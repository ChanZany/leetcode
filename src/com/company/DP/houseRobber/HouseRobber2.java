package com.company.DP.houseRobber;

import java.util.Arrays;

/**
 在打家劫舍1的基础上、额外增加了一个限制条件：首尾的house不能同时偷（环形）
 1. 考虑0~n-1号房，不考虑n号
 2. 考虑1~n号房，不考虑0号
 对于每个情况的处理和打家劫舍1相同
 dp[i]=max(dp[i-1],dp[i-2]+nums[i])
 */
public class HouseRobber2 {
    public int rob(int[] nums) {
        if (nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        //划分情况
        return Math.max(
                dynamicProgram(Arrays.copyOfRange(nums,0,nums.length-1)),       //condition 1
                dynamicProgram(Arrays.copyOfRange(nums,1,nums.length))        //condition 2
                );
    }

    public int dynamicProgram(int[] nums){
        if (nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }

}
