package org.algorithm.category.binarytree.modify;


import org.algorithm.category.binarytree.TreeNode;

/**
 * 669
 */
public class TrimBST {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null){
            return null;
        }

        if(root.val<low){
            return trimBST(root.right,low,high);
        }else if(root.val>high){
            return trimBST(root.left,low,high);
        }else {
            TreeNode left = root.left;
            TreeNode right = root.right;

            root.left = trimBST(left,low,high);
            root.right = trimBST(right,low,high);
            return root;
        }

    }
}
