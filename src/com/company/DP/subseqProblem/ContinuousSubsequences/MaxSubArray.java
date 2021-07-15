package com.company.DP.subseqProblem.ContinuousSubsequences;

/**53. 最大子序和
 给定一个整数数组 nums ，找到一个具有最大和的【连续子数组】（子数组最少包含一个元素），返回其最大和。
 定义：dp[i]：【包括下标i】之前的最⼤连续⼦序列和为dp[i]。
 转移：dp[i]只能由两个方向推出：
    1. dp[i] = dp[i-1] + nums[i]  即：nums[i]加⼊当前连续⼦序列和
    2. nums[i]  即：从头开始计算当前连续⼦序列和
    一定是取最大的，所以dp[i] = max(dp[i - 1] + nums[i], nums[i]);
 初始化：dp[0] = nums[0]
 注意最后的结果可不是dp[nums.size() - 1]，这是由于dp的定义所导致的
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int res = 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
