package com.company.DP.packageProblem.packageFull;



/**
 * @Author ChanZany
 * @Date 2021/7/6 17:21
 * @Version 1.0
 */
public class ClimbStairs {
    /*回溯法,每一步都有两种选择，选择走一步或者是两步
    int res = 0;
    public int climbStairs(int n) {
        backtracking(0,n);
        return res;
    }
    private void backtracking(int cur, int n){
        if(cur==n){
            res ++;
            return;
        }
        if(cur+1<=n) backtracking(cur+1,n);
        if(cur+2<=n) backtracking(cur+2,n);
    }*/

    //动态规划
    //1.dp[i]表示到达第i层楼梯有多少种方法->目标是啥,dp[i]就是啥，重要的是找到i的具体含义
    //2.初始值：dp[1]=1,dp[2]=2
    //3.转移方程,dp[i]=dp[i-1]+dp[i-2]
    //4.遍历顺序：从前往后
    //5.举例：dp[3] = [(1,1,1),(1,2),(2,1)] = 3 = dp[2] + dp[1]
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-2]+dp[i-1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbStairs Main = new ClimbStairs();
//        System.out.println(Main.climbStairs(1));
//        System.out.println(Main.climbStairs(2));
//        System.out.println(Main.climbStairs(3));
        System.out.println(Main.climbStairs(4));
    }
}
