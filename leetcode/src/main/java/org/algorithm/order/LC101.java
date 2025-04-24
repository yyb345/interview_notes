package org.algorithm.order;

import org.algorithm.category.binarytree.TreeNode;

/**
 * 101
 * 判断二叉树是否为对称
 * 时间复杂度O(N) 空间复杂度O(1)
 */
public class LC101 {

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return symmetricTree(root.left,root.right);
    }

    public boolean symmetricTree(TreeNode t1,TreeNode t2){
        if(t1==null && t2==null){
            return true;
        }else if(t1!=null && t2==null){
            return false;
        }else if(t1==null && t2!=null){
            return false;
        }else {
            if(t1.val!=t2.val){
                return false;
            }
            return symmetricTree(t1.left,t2.right) && symmetricTree(t1.right,t2.left);
        }
    }
}
