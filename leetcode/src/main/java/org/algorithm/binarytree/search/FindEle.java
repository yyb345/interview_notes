package org.algorithm.binarytree.search;

import org.algorithm.binarytree.TreeNode;
import org.algorithm.tool.TreeTool;


/**
 * 1261
 */
public class FindEle {

    TreeNode root = null;

    public FindEle(TreeNode root) {
        this.root = root;
        dfs(this.root, 0);
    }

    void dfs(TreeNode root, int val) {
        if (root == null) {
            return;
        }

        root.val = val;
        dfs(root.left, 2 * val + 1);
        dfs(root.right, 2 * val + 2);
    }

    public boolean find(int target) {

        return findTarget(target)!=null;
    }

    TreeNode findTarget(int num) {
        if (this.root == null) {
            return null;
        }

        if (num == 0) {
            return this.root;
        }
        if (num % 2 == 0) {
            TreeNode r = findTarget((num - 2) / 2);
            if (r != null && r.right != null) {
                return r.right;
            }
        } else {
            TreeNode l = findTarget((num - 1) / 2);
            if (l != null && l.left != null) {
                return l.left;
            }
        }

        return null;
    }

    public static void main(String[] args) {


        FindEle findEle = new FindEle(TreeTool.buildTree(new Integer[]{-1, -1, -1, null, null, -1, -1, null, null, null, -1}));
        findEle.find(6);
//        findEle.find(1);
//        findEle.find(6);
    }
}
