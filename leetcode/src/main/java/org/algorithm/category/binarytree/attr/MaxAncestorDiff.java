

package org.algorithm.category.binarytree.attr;

import org.algorithm.category.binarytree.TreeNode;
/**
 * 1026
 * 祖先和任意孩子节点差值最大
 */
public class MaxAncestorDiff {

    public int maxAncestorDiff(TreeNode root) {

        return dfs(root,root.val,root.val);

    }

    int dfs(TreeNode root,int max,int min){
        if(root==null){
            return max-min;
        }
        int mmax=Math.max(root.val,max);
        int mmin=Math.min(root.val,min);

        int left = dfs(root.left,mmax,mmin);
        int right = dfs(root.right,mmax,mmin);

        return Math.max(left,right);

    }
}
