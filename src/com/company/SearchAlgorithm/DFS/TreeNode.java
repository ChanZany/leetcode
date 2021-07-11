package com.company.SearchAlgorithm.DFS;

/**
 * @Author ChanZany
 * @Date 2021/7/5 21:46
 * @Version 1.0
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val){this.val=val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val=val;
        this.left = left;
        this.right = right;
    }
}
