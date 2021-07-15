package com.company.DP.subseqProblem.ContinuousSubsequences;

import java.util.Arrays;

/**718. 最⻓重复⼦数组
 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 这也是一个连续子序列问题
 定义dp[i][j]：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最⻓重复⼦数组⻓度
 转移：dp[i][j] = nums1[i] == nums2[j] ? dp[i-1][j-1]+1 : dp[i-1][j-1]
 初始化，dp[i][0] = dp[0][j] = 0
 */
public class LengthOfLRS {
    public int findLength1(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i-1]==nums2[j-1]) dp[i][j] = dp[i-1][j-1]+1;
                res = Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
    //滚动数组解法
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] dp = new int[n+1];
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = n; j > 0; j--) {
                if (nums1[i-1]==nums2[j-1]) dp[j] = dp[j-1]+1;
                else dp[j] = 0;                 // 注意这⾥不相等的时候要有赋0的操作
                res = Math.max(res,dp[j]);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        LengthOfLRS Main = new LengthOfLRS();
        int [] nums1 = {1,2,3,2,1};
        int [] nums2 = {3,2,1,4,7};
        System.out.println(Main.findLength(nums1, nums2));
    }
}
