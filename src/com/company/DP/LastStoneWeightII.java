package com.company.DP;

import java.util.Arrays;

/**
 * @Author ChanZany
 * @Date 2021/7/7 20:51
 * @Version 1.0
 */
public class LastStoneWeightII {
    //尽量将石头分成重量相同的两堆，相撞之后剩下的石头最小 -> 求解分割等和字节
    //定义: 容量为j的背包，最多可以背dp[j]这么重的石头
    //转移: dp[j] = max(dp[j],dp[j-stones[i]]+stones[i])
    //目标为：dp[target = sum/2] = target, j最大取target+1
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target = sum/2;
        int[] dp = new int[target+ 1];
        for (int i = 0; i < stones.length; i++) {
            for(int j=target;j>=stones[i];j--){
                dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return sum-(dp[target]+dp[target]); //找到了两两相同(最大)重为dp[target]的子集，二者相互抵消，剩下的就是相撞后的最小石头重量
    }
}
