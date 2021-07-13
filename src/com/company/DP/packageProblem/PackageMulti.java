package com.company.DP.packageProblem;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 多重背包：
 * 有 K 种物品和一个容量为 M 的背包，每件物品最多有N[i]件可用，每件耗费的空间是W[i]，价值是V[i]
 * 求解把哪些物品装入背包可以使得背包可携带的物品价值总和最大
 * 多重背包和01背包很像，每件物品最多有N[i]件可用，将N[i]件摊开，其实就是一个01背包问题了
 */
public class PackageMulti {
    int[] W = {1, 3, 4};
    int[] V = {15, 20, 30};
    int[] N = {2, 3, 2};
    int bagCap = 10;

    int multiPackage() {
        ArrayList<Integer> weight = arrtoList(W);
        ArrayList<Integer> value = arrtoList(V);
        ArrayList<Integer> nums = arrtoList(N);

        //将多重背包问题转换为01背包问题
        for (int i = 0; i < nums.size(); i++) {
            while (nums.get(i) > 1) {   //将多件物品展开
                weight.add(weight.get(i));
                value.add(value.get(i));
                nums.set(i, nums.get(i) - 1);
            }
        }
        //解决01背包问题
        int[] dp = new int[bagCap + 1];
        for (int i = 0; i < weight.size(); i++) {     //外层物品
            for (int j = bagCap; j >= weight.get(i); j--) { //内层容量，逆序
                dp[j] = Math.max(dp[j], dp[j - weight.get(i)] + value.get(i));
            }
            System.out.println(Arrays.toString(dp));
        }

        return dp[bagCap];
    }

    private ArrayList<Integer> arrtoList(int[] w) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.stream(w).forEach(list::add);
        return list;
    }


    public static void main(String[] args) {
        PackageMulti Main = new PackageMulti();
        System.out.println(Main.multiPackage());
    }


}
