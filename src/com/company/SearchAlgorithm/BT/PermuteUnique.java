package com.company.SearchAlgorithm.BT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ChanZany
 * @Date 2021/7/6 8:39
 * @Version 1.0
 *
 * https://leetcode-cn.com/problems/permutations-ii/solution/dai-ma-sui-xiang-lu-dai-ni-xue-tou-hui-s-ki1h/
 */
public class PermuteUnique {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    //全排列，存在重复元素
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length < 1) return null;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited);
        return res;
    }

    private void backtrack(int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // visited[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
            // visited[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
            // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) continue;
            if (!visited[i]){
                visited[i] = true;
                path.add(nums[i]);
                backtrack(nums,visited);
                path.remove(path.size()-1);
                visited[i] = false;
            }

        }
    }


    public static void main(String[] args) {
        PermuteUnique Main = new PermuteUnique();
        int[] nums = {1, 1, 3};
        Main.permuteUnique(nums).forEach(list -> {
            list.forEach(System.out::print);
            System.out.println();
        });
    }
}
