package org.algorithm.category.binarytree.build;

import org.algorithm.category.binarytree.TreeNode;

/**
 * 105
 * Construct Binary Tree from Preorder and Inorder Traversal
 */
public class PreOrderInOrderTree105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return dfs(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode dfs(int[] preorder, int preStart,int preEnd,int[] inorder,int iStart,int iEnd) {
        if(iStart>iEnd){
            return null;
        }

        if(iStart==iEnd){
            return new TreeNode(inorder[iStart]);
        }

        int rootIndex = findRootIndex(inorder,iStart,iEnd,preorder[preStart]);

        TreeNode root = new TreeNode(inorder[rootIndex]);
        int leftLen = rootIndex-iStart;
        TreeNode left = dfs(preorder,preStart+1,preStart+leftLen,inorder,iStart,rootIndex-1);
        TreeNode right = dfs(preorder,preStart+leftLen+1,preEnd,inorder,rootIndex+1,iEnd);
        root.left = left;
        root.right = right;

        return root;
    }

    int findRootIndex(int[] nums,int start,int end,int target){

        for(int i=start;i<=end;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
}
