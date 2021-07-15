package com.company.DP.subseqProblem.DiscontinuousSubsequences;

import com.company.DP.subseqProblem.DebugUtils;

/**1143.最⻓公共⼦序列
 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。如果不存在 公共子序列 ，返回 0 。
 本题和动态规划：718. 最⻓重复⼦数组区别在于这⾥不要求是连续的了，但要有相对顺序，
 即："ace"是 "abcde" 的⼦序列，但 "aec" 不是 "abcde" 的⼦序列。
 定义 dp[i][j]：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最⻓公共⼦序列的⻓度
 转移：
 主要就是两⼤情况：text1[i - 1] 与 text2[j - 1]相同，text1[i - 1] 与 text2[j - 1]不同
 如果text1[i - 1] 与 text2[j - 1]相同，那么找到了⼀个公共元素，所以dp[i][j] = dp[i - 1][j - 1] + 1;
 如果text1[i - 1] 与 text2[j - 1]不相同，那就看看text1[0, i - 2]与text2[0, j - 1]的最⻓公共⼦序列和
 text1[0, i - 1]与text2[0, j - 2]的最⻓公共⼦序列，取最⼤的。即：dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
 初始化：dp[i][0] = dp[0][j] = 0
 */
public class LengthOfLCS {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        LengthOfLCS Main = new LengthOfLCS();
        Main.longestCommonSubsequence(text1,text2);
    }
}
