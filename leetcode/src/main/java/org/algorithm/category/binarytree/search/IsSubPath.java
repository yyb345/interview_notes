package org.algorithm.category.binarytree.search;

import org.algorithm.category.binarytree.TreeNode;
import org.algorithm.ListNode;

/**
 * 1367
 */
public class IsSubPath {

    public boolean isSubPath(ListNode head, TreeNode root) {

        if(head==null){
            return true;
        }

        if(root==null){
            return false;
        }

        if(dfs(head,root)){
            return true;
        }

        return isSubPath(head,root.left) || isSubPath(head,root.right);

    }

    boolean dfs(ListNode head, TreeNode root){
        if(head==null){
            return true;
        }
        if(root==null){
            return false;
        }
        if(head.val!=root.val){
            return false;
        }

        return dfs(head.next,root.left) || dfs(head.next,root.right);

    }
}
