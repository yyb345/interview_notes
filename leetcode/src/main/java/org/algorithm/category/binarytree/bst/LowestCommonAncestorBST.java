package org.algorithm.category.binarytree.bst;

import org.algorithm.category.binarytree.TreeNode;

/**
 * 235
 * 二叉搜索树 最近公共父节点
 */
public class LowestCommonAncestorBST {

    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null){
            return null;
        }

        if(root.val>p.val && root.val>q.val){
            return lowestCommonAncestorBST(root.left,p,q);
        }else if(root.val<p.val && root.val<q.val){
            return lowestCommonAncestorBST(root.right,p,q);
        }else {
            return root;
        }
    }
}
