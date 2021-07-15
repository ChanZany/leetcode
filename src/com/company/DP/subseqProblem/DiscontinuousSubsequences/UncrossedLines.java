package com.company.DP.subseqProblem.DiscontinuousSubsequences;

/**1035. 不相交的线
 我们在两条独⽴的⽔平线上按给定的顺序写下 A 和 B 中的整数。
 现在，我们可以绘制⼀些连接两个数字 A[i] 和 B[j] 的直线，只要 A[i] == B[j]，且我们绘制的直线不与任何其他连线（⾮⽔平线）相交。
 以这种⽅法绘制线条，并返回我们可以绘制的最⼤连线数。
 【分析】
 拿示例⼀A = [1,4,2], B = [1,2,4]为例，相交情况如题目示例：
 其实也就是说A和B的最⻓公共⼦序列是[1,4]，⻓度为2。 这个公共⼦序列指的是相对顺序不变
 （即数字4在字符串A中数字1的后⾯，那么数字4也应该在字符串B数字1的后⾯）
 本题说是求绘制的最⼤连线数，其实就是求两个字符串的最⻓公共⼦序列的⻓度！
 那么本题就和1143.最⻓公共⼦序列就是⼀样⼀样的了
 */
public class UncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][]dp = new int[m+1][n+1];      //表示nums1[0:m]和nums2[0:n]的最长公共子序列长度
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
