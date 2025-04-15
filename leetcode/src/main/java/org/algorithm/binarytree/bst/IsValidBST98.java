package org.algorithm.binarytree.bst;

import org.algorithm.binarytree.TreeNode;

/**
 * 98
 * 判断是否为BST
 * 时间复杂度O(N) 空间复杂度O(1)
 */
public class IsValidBST98 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}
