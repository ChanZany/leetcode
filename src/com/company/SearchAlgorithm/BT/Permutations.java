package com.company.SearchAlgorithm.BT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ChanZany
 * @Date 2021/7/5 13:19
 * @Version 1.0
 * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 */
public class Permutations {

    //思路1：选择当前元素 or 不选
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length < 1) return null;
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void dfs(List<List<Integer>> res, ArrayList<Integer> cur, int[] arr, boolean[] visited) {
        if (cur.size() == arr.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                cur.add(arr[i]);
                dfs(res, cur, arr, visited);
                visited[i] = false;
                cur.remove(cur.size() - 1);
            }
        }

    }


    //思路2：交换当前元素 or 不换
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(nums, 0, res);
        return res;
    }

    private void backtracking(int[] nums, int level, List<List<Integer>> res) {
        if (level == nums.length - 1) {
            ArrayList<Integer> ans = new ArrayList<>();
            Arrays.stream(nums).forEach(ans::add);
            res.add(ans);
        }

        for (int i = level; i < nums.length; i++) {
            swap(nums, i, level);                               // 修改当前节点状态
            backtracking(nums, level + 1, res);           // 递归子节点
            swap(nums, i, level);                               // 回改当前节点状态
        }

    }

    private void swap(int[] nums, int a, int b) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
    }


    public static void main(String[] args) {
        Permutations Main = new Permutations();
        int[] nums = {1, 2, 3};
        Main.permute2(nums).forEach(list -> {
            list.forEach(System.out::print);
            System.out.println();
        });
    }
}
