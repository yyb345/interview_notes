package org.algorithm.category.binarytree.bst;

import org.algorithm.category.binarytree.TreeNode;
import org.algorithm.category.tool.TreeTool;

/**
 * 230
 * 中序遍历，count计数
 */
public class KthSmallest {

    // leetcode
    int val = -1;
    int count=0;
    int _k;
    public  int kthSmallest(TreeNode root, int k) {
        this._k=k;
        dfs(root);
        return val;
    }

    void dfs(TreeNode root){
        if(root==null){
            return;
        }

        dfs(root.left);
        count++;
        if(count==_k){
            val=root.val;
            return;
        }
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeTool.buildTree(new Integer[]{5,3,6,2,4,null,null,1});
        System.out.println(new KthSmallest().kthSmallest(treeNode,3));
    }

}
