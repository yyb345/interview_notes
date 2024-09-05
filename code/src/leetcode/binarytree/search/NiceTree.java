package leetcode.binarytree.search;


import leetcode.binarytree.TreeNode;

public class NiceTree {

    TreeNode root;




    boolean query(int target){

        if(queryNode(target)!=null){
            return true;
        }

        return false;
    }

    TreeNode queryNode(int target){

        if(target==0){
            return root;
        }

        if(target<root.val){
            return null;
        }

        if(target%2==1){
            TreeNode leftParent = queryNode((target-1)/2);
            if(leftParent!=null && leftParent.left.val==target){
                return leftParent.left;
            }
        }

        if(target%2==0){
            TreeNode rightParent = queryNode((target-2)/2);
            if(rightParent!=null && rightParent.right.val==target){
                return rightParent.right;
            }
        }


        return null;
    }
}
