package com.company.DP.packageProblem.packageFull;

import java.util.Arrays;

/**
 * @Author ChanZany
 * @Date 2021/7/8 18:41
 * @Version 1.0
给你一个由【不同】整数组成的数组nums，和一个目标整数 target 。请你从nums中找出并返回总和为target的元素组合的个数。
 分析：
 虽然是求组合，但是题目说顺序不同的序列被视作不同的组合，所以其实就是求全排列，通常可以使用回溯算法我干爆他
 但是本题求的是排列的总个数，不需要把所有的排列列出来，所以就考虑DP，用更低的时间复杂度解决该问题
 定义：凑出正整数j的排列个数为dp[j]
 转移：dp[j] += dp[j-nums[i]]
 顺序：
    - 如果是求组合数就是外层遍历物品，内层遍历背包
    - 如果是求排列数就是外层遍历背包，内层遍历物品
 初始值：dp[0]=1,无实际意义，只是为了转移方程的合理性
 举例： nums = [1,2,3],target=4
        dp[0]=1, dp[1] += dp[1-1]=1, dp[2] += dp[2-nums[i]],nums[i]<=2 = dp[1]+dp[0]=2
        dp[3] += dp[3-nums[i]] = dp[2]+dp[1]+dp[0] = 4
        解释dp[3]：[1,2],[2,1],[0,3],[3,0]
 */
public class CombinationSum4 {

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target+1];
        dp[0]=1;
        for (int j=0;j<=target;j++){
            for (int i = 0; i < nums.length && nums[i]<=j; i++) {
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}
