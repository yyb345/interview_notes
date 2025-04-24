package org.algorithm.order;

import org.algorithm.category.binarytree.TreeNode;

/**
 * 104
 * 二叉树最大深度
 */
public class LC104 {

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
