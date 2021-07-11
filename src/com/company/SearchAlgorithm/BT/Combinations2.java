package com.company.SearchAlgorithm.BT;

import java.util.*;

/**
 * @Author ChanZany
 * @Date 2021/7/6 9:04
 * @Version 1.0
 * 每个数字在每个组合中只能使用一次，所以需要startIdx来保证每次递归所添加的元素不重不漏
 * https://leetcode-cn.com/problems/combination-sum-ii/solution/dai-ma-sui-xiang-lu-dai-ni-xue-tou-hui-s-ig29/
 */
public class Combinations2 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> deque = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        backtrack(candidates, target, 0, visited);
        return res;
    }

    private void backtrack(int[] a, int target, int startIdx, boolean[] visited) {
        if (sum == target) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = startIdx; i < a.length && a[i] + sum <= target; i++) {
            if (i > 0 && a[i - 1] == a[i] && !visited[i - 1]) continue;
            visited[i] = true;
            sum += a[i];
            deque.push(a[i]);
//            backtrack(a, target, startIdx + 1, visited);    //err:
            backtrack(a, target, i + 1, visited);    //right
            int tmp = deque.pop();
            visited[i] = false;
            sum -= tmp;
        }

    }
}

