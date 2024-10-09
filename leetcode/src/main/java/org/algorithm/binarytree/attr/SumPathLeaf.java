package org.algorithm.binarytree.attr;

import org.algorithm.binarytree.TreeNode;

/**
 * 1022
 * 根路径到叶子节点二进制的数值求和
 * For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
 */
public class SumPathLeaf {
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root,0);
        return sum;
    }

    void dfs(TreeNode root,int pathSum){
        if(root==null){
            return;
        }

        pathSum= (pathSum)*2+root.val;
        if(root.left==null && root.right==null){
            sum += pathSum;
        }

        dfs(root.left,pathSum);
        dfs(root.right,pathSum);
    }
}
