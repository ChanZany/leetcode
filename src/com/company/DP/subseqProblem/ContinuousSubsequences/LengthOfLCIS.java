package com.company.DP.subseqProblem.ContinuousSubsequences;

import java.util.Arrays;

/**674. 最⻓连续递增序列
给定一个未经排序的整数数组，找到最长且【连续递增】的子序列，并返回该序列的长度。
 定义：dp[i]为nums[0:i]内的LCIS
 转移：if nums[i]>nums[i-1], dp[i] = dp[i-1] + 1
 需要记录dp[i]的最大值
 初始值：dp[i]=1
 */
public class LengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int [] dp = new int[n];
        Arrays.fill(dp,1);
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i]>nums[i-1]) dp[i] = dp[i-1] + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        LengthOfLCIS Main = new LengthOfLCIS();
        int[] nums = {1,3,5,4,7};
        System.out.println(Main.findLengthOfLCIS(nums));
    }
}
