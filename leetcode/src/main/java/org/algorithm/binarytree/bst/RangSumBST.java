package org.algorithm.binarytree.bst;

import org.algorithm.binarytree.TreeNode;

/**
 * 938
 */
public class RangSumBST {

    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {

        dfs(root,low,high);
        return sum;
    }

    void dfs(TreeNode root, int low, int high){
        if(root==null){
            return;
        }

        if(root.val<low){
            dfs(root.right,low,high);
        }else if(root.val>high){
            dfs(root.left,low,high);
        }else {
            sum+= root.val;
            dfs(root.left,low,high);
            dfs(root.right,low,high);
        }
    }
}
