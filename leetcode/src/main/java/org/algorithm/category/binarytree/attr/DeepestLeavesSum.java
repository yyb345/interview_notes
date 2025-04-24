package org.algorithm.category.binarytree.attr;

import org.algorithm.category.binarytree.TreeNode;

/**
 * 1302
 * （最深的叶子节点）之和
 *  时间复杂度 O(N) 空间复杂度 O(1)
 */
public class DeepestLeavesSum {

    int maxSum=0;
    Integer maxDepth = 0;

    public int deepestLeavesSum(TreeNode root) {

        dfs(root,0);
        return maxSum;
    }

    void dfs(TreeNode root, int depth){
        if(root==null){
            return;
        }

        if(root.left==null && root.right==null){
            if(depth>maxDepth){
                maxDepth = depth;
                maxSum = root.val;
            }else if(depth==maxDepth){
                maxSum += root.val;
            }
        }

        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
}
