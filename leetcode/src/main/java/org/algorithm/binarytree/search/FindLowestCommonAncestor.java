package org.algorithm.binarytree.search;

import org.algorithm.binarytree.TreeNode;

/**
 * 236
 * 二叉树寻找最近公共父节点
 */
public class FindLowestCommonAncestor {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null){
            return null;
        }

        if(root==p || root==q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left!=null && right!=null){
            return root;
        }else if(left==null && right!=null){
            return right;
        }else if(left!=null && right==null){
            return left;
        }

        return null;

    }
}
