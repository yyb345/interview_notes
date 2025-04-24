package org.algorithm.category.binarytree;


/**
 * 1372. 二叉树中的最长交错路径
 */

public class ZigPath {

    int max=0;
    public int longestZigZag(TreeNode root) {

        if(root==null){
            return 0;
        }

        dfs(root.left,0,'l');
        dfs(root.right,0,'r');
        return max;
    }


    void dfs(TreeNode root,int num,char c){

        if(root==null){
            max = Math.max(max,num);
            return;
        }

        if('l'==c){
            dfs(root.right,num+1,'r');
            dfs(root.left,0,'l');
        }else {
            dfs(root.left,num+1,'l');
            dfs(root.right,0,'r');
        }
    }
}
