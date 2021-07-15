package com.company.DP.subseqProblem.DiscontinuousSubsequences;

import java.util.Arrays;

/**300.最⻓递增⼦序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * 定义：dp[i]表示位置i之前包括i的LIS长度
 * 转移：对于j<i,if(nums[i]>nums[j]) dp[i] = max(dp[i], dp[j] + 1)
 * else dp[i] = dp[i-1]
 * 顺序：从前往后
 * 初始值：i>0,dp[i]=1,至少LIS长度为1
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res,dp[i]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        LengthOfLIS Main = new LengthOfLIS();
        int[] nums = {0, 1, 0, 3, 2};
        Main.lengthOfLIS(nums);
    }
}
