package org.algorithm.binarytree.travel;

import org.algorithm.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257
 * root->leaf
 */
public class BinaryTreePaths {

    List<String> ret = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, new ArrayList<>());
        return ret;
    }

    void dfs(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (Integer v : path) {
                sb.append(v).append("->");
            }
            sb.append(root.val);
            ret.add(sb.toString());
            return;
        }

        path.add(root.val);
        dfs(root.left, path);
        dfs(root.right, path);
        path.remove(path.size() - 1);

    }
}
