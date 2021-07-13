package com.company.DP.houseRobber;

/**
 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 定义：考虑0~i以内的房屋，最多可以偷窃的金额为dp[i]
 转移：决定dp[i]的因素就是第i间房偷还是不偷
    如果偷第i间房，那么dp[i]=dp[i-2]+nums[i]，即第i-1间房是不考虑的
    如果不偷第i间房，则需要考虑偷第i-1房，dp[i]=dp[i-1]
    dp[i] = max(dp[i-2]+nums[i],dp[i-1])
 初始化：
    dp[0]=nums[0]
    dp[1]=max(nums[0],nums[1])
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
}
