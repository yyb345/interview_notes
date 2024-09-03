package leetcode.binarytree;


import treeproblem.TreeNode;

public class TrimBST {

    public static TreeNode trimBST(TreeNode root, int L, int R) {

        int value=root.val;

        TreeNode newRoot=null;
        if(value>=L && value<=R){
            newRoot=new TreeNode(value);
            if(root.left!=null)
                newRoot.left=trimBST(root.left,L,R);
            if(root.right!=null)
                newRoot.right=trimBST(root.right,L,R);

        }else if(value<L){
            if(root.right!=null){
                newRoot=trimBST(root.right,L,R);
            }

        }else if(value>R){
            if(root.left!=null){
                newRoot=trimBST(root.left,L,R);
            }

        }
        return newRoot;
    }
}
