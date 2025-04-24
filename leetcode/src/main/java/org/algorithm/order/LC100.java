package org.algorithm.order;

import org.algorithm.category.binarytree.TreeNode;

/**
 * 100
 * 判断是否两个树相同
 */
public class LC100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }else if(p==null && q!=null){
            return false;
        }else if(p!=null && q==null){
            return false;
        }else {
            if(p.val!=q.val){
                return false;
            }
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }
}
