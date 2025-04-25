package org.algorithm.order;

import org.algorithm.category.binarytree.TreeNode;

/**
 * 112
 * 判断二叉树从根节点到叶子节点，sum是否为指定值
 */
public class LC112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        if(root.val == targetSum && root.left==null && root.right==null){
            return true;
        }

        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }
}
