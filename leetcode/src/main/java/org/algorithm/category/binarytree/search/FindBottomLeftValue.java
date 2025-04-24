package org.algorithm.category.binarytree.search;

import org.algorithm.category.binarytree.TreeNode;

/**
 * 513
 * 寻找最左、最深的节点
 */
public class FindBottomLeftValue {

    int maxPath = -1;
    int val = -1;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return val;
    }

    void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null) {
            if (depth > maxPath) {
                val = root.val;
                maxPath = depth;
            }
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
