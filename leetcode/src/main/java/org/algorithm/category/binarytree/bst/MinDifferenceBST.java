package org.algorithm.category.binarytree.bst;

import org.algorithm.category.binarytree.TreeNode;

/**
 * 530
 * BST中两个节点差值，求最小
 * 时间复杂度O(N) 空间复杂度 O(1)
 */
public class MinDifferenceBST {

    Integer pre;
    int minVal = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return minVal;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        if (pre != null) {
            minVal = Math.min(minVal, root.val - pre);
        }
        pre = root.val;
        dfs(root.right);

    }
}
