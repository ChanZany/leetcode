package com.company.SearchAlgorithm.BT;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author ChanZany
 * @Date 2021/7/5 14:10
 * @Version 1.0
如果解决一个问题有多个步骤，每一个步骤有多种方法，题目又要我们找出所有的方法，可以使用回溯算法；
回溯算法是在一棵树上的 深度优先遍历（因为要找所有的解，所以需要遍历）；
组合问题，相对于排列问题而言，不计较一个组合内元素的顺序性（即 [1, 2, 3] 与 [1, 3, 2] 认为是同一个组合），
因此很多时候需要按某种顺序展开搜索，这样才能做到不重不漏。
https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        backtracking(n, k, 1, path, res);
        return res;
    }

    private void backtracking(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res){
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=begin;i<=n;i++){
            path.addLast(i);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            backtracking(n,k,i+1,path,res);
            path.removeLast();
        }
    }


}
