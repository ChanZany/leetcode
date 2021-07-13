package com.company.DP.houseRobber;

/**
 * 在打家劫舍的基础上增加了树的结构，
 * 如果抢了当前节点，左子和右子就不能动，
 * 如果没抢当前节点，可以考虑抢左子以及右子
 * 动态规划+递归解法：
 * 定义递归函数：
 * int[] robTree(TreeNode cur)->dp
 * dp[0]记录不偷当前节点(cur)所获得的最大金钱
 * dp[1]记录偷当前节点(cur)所获得的最大金钱
 * 终止条件:
 * if(cur==null) return new int[]{0,0}
 * 确定遍历顺序：
 * 后续遍历，因为通过递归函数的返回值来做下一步计算
 * 通过递归左节点，得到左节点偷与不偷的金钱
 * 通过递归右节点，得到右节点偷与不偷的金钱
 * int[] left = robTree(cur.left);
 * int[] right = robTree(cur.right);
 * 单层递归的逻辑
 * 如果偷当前节点，那么左右子都不能偷,val1=cur.val+left[0]+right[0]
 * 如果不偷当前节点，那么左右子都可以偷，val2=max(left[0],left[1])+max(right[0],right[1])
 * 最后当前节点的状态就是{val2,val1}
 */
public class HouseRobber3 {
    /*解法1：暴力递归
    public int rob(TreeNode root) {
        if (root==null) return 0;
        if (root.left==null && root.right==null) return root.val;
        //偷父节点
        int val1 = root.val;
        if (root.left!=null) val1 += rob(root.left.left)+rob(root.left.right);  //跳过左子
        if (root.right!=null) val1 += rob(root.right.left)+rob(root.right.right);   //跳过右子
        //不偷父节点
        int val2 = rob(root.left) + rob(root.right);
        return Math.max(val1,val2);
    }*/

    /*解法2：记忆法递归
      可以使用一个map将计算过的结果保存以下，这样如果计算过孙子了，那么计算孩子的时候可以复用孙子节点的结果

    Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        if (map.containsKey(root)) return map.get(root);

        //偷父节点
        int val1 = root.val;
        if (root.left != null) val1 += rob(root.left.left) + rob(root.left.right);
        if (root.right != null) val1 += rob(root.right.left) + rob(root.right.right);
        //不偷父节点
        int val2 = rob(root.left) + rob(root.right);
        map.put(root, Math.max(val1, val2));
        return Math.max(val1, val2);
    }*/

    //动态规划+递归
    public int rob(TreeNode root) {
        int[] res = robTree(root);
        return Math.max(res[0], res[1]);
    }

    //长度为2的数组，0：不偷，1：偷
    private int[] robTree(TreeNode cur) {
        if (cur == null) return new int[]{0, 0};
        int[] left = robTree(cur.left);
        int[] right = robTree(cur.right);
        //偷cur
        int val1 = cur.val + left[0] + right[0];
        //不偷cur
        int val2 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{val2, val1};
    }


}
