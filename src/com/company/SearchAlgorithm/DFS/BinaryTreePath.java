package com.company.SearchAlgorithm.DFS;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author ChanZany
 * @Date 2021/7/5 21:45
 * @Version 1.0
 * https://leetcode-cn.com/problems/binary-tree-paths/solution/yi-pian-wen-zhang-jie-jue-suo-you-er-cha-5f58/
 */
public class BinaryTreePath {
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return null;
        dfs(root, "");
        return res;
    }

    private void dfs(TreeNode node, String path) {
        if (node == null) return;
        path += node.val;
        if (node.left == null && node.right == null) {  //叶子结点
            res.add(path);
            return;
        }
        dfs(node.left, path + "->");
        dfs(node.right, path + "->");
    }

}
