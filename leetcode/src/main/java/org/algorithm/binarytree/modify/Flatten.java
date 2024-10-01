package org.algorithm.binarytree.modify;

import org.algorithm.binarytree.TreeNode;

public class Flatten {

    TreeNode preNode = null;
    public void flatten(TreeNode root) {
        dfs(root);
    }

    void dfs(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode ll = root.left;
        TreeNode rr = root.right;

        if(preNode == null){
            preNode = root;
        }else{
            preNode.right = root;
            preNode = root;
        }
        dfs(ll);
        dfs(rr);
    }
}
