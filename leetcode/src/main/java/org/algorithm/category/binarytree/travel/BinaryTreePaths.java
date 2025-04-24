package org.algorithm.category.binarytree.travel;

import org.algorithm.category.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257
 * root->leaf
 */
public class BinaryTreePaths {

    List<String> ret = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return ret;
    }

    void dfs(TreeNode root, String path) {
        if (root == null) {
            return;
        }
        path+=root.val;
        if (root.left == null && root.right == null) {
            ret.add(path);
            return;
        }
        dfs(root.left, path+"->");
        dfs(root.right, path+"->");
    }
}
