package leetcode.binarytree;

import treeproblem.TreeNode;


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
        // return Math.max(Math.max(startPath(root.left,'l'),
        // startPath(root.right,'r')),
        // max);


    }

    // int startPath(TreeNode root,char d){
    //     if(root==null){
    //         return 0;
    //     }

    //     int right=startPath(root.right,'r');
    //     int left=startPath(root.left,'l');
    //     max = Math.max(Math.max(left,right),max);
    //     if(d=='l'){
    //        return right+1;
    //     }else if(d=='r'){
    //         return left+1;
    //     }

    //     return 0;

    // }

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
