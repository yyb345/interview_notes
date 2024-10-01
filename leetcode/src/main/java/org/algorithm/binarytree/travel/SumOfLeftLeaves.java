package org.algorithm.binarytree.travel;


import org.algorithm.binarytree.TreeNode;
import org.algorithm.tool.TreeTool;


/**
 * 404
 * 叶子节点 且是 左叶子节点  值之和
 * 代码优化 7%---100%
 */
public class SumOfLeftLeaves {

    int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root,'x');
        return sum;
    }

    void dfs(TreeNode root,char d){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null && d=='l'){
            sum+=root.val;
            return;
        }

        dfs(root.left,'l');
        dfs(root.right,'r');
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeTool.buildTree(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(treeNode));
    }
}
