package leetcode.binarytree;


import treeproblem.TreeNode;

//TODO 重写一遍
public class SumOfLeftLeaves {

    // 404. Sum of Left Leaves
    public static int sumOfLeftLeaves(TreeNode root) {
        int result=0;

        if(root==null){

        }else{
            if(root.left!=null){
                if(root.left.left==null && root.left.right==null){
                    result=root.left.val;
                }else {
                    result+=sumOfLeftLeaves(root.left);
                }

            }
            if(root.right!=null){
                result+=sumOfLeftLeaves(root.right);

            }
        }


        return result;
    }
}
