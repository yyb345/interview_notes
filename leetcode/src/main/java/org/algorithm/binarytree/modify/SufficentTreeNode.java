package org.algorithm.binarytree.modify;

import org.algorithm.binarytree.TreeNode;

/**
 * 1080
 */
public class SufficentTreeNode {

    public TreeNode sufficientSubset(TreeNode root, int limit) {

        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            if (root.val < limit) {
                return null;
            }
        } else {
            TreeNode left = sufficientSubset(root.left, limit - root.val);
            TreeNode right = sufficientSubset(root.right, limit - root.val);

            if (left == null && right == null) {
                return null;
            }

            root.left = left;
            root.right = right;
        }

        return root;
    }
}
