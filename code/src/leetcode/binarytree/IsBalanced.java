package leetcode.binarytree;


/** 110
 * 判断是否是平衡二叉树
 */

public class IsBalanced {


    public boolean isBalanced(TreeNode root) {

        return dfs(root)>-1;
    }

    int dfs(TreeNode root){
        if(root==null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        if(left==-1){
            return -1;
        }

        if(right==-1){
            return -1;
        }
        if(Math.abs(left-right)>1){
            return -1;
        }

        return Math.max(left,right)+1;
    }
}
