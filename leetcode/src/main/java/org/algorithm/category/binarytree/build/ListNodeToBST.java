package org.algorithm.category.binarytree.build;

import org.algorithm.category.ListNode;
import org.algorithm.category.binarytree.TreeNode;

/**
 * 109
 * 有序的ListNode转为BST
 *
 */
public class ListNodeToBST {

    public TreeNode sortedListToBST(ListNode head) {

        if(head==null){
            return null;
        }
        if(head.next==null){
            return new TreeNode(head.val);
        }

        // 1. compute ListNode len
        ListNode iter = head;
        int len = 0;
        while(iter!=null){
            len++;
            iter = iter.next;
        }

        // 2. find midNode that is root
        int mid = len/2;
        ListNode midNode = head;
        ListNode midPreNode = null;
        int count=1;
        while(count<=mid && midNode!=null){
            count++;
            midPreNode=midNode;
            midNode = midNode.next;
        }
        // 3. split left and right
        midPreNode.next=null;

        // 4. build treeNode
        TreeNode root = new TreeNode(midNode.val);
        // left
        root.left = sortedListToBST(head);
        // right
        root.right= sortedListToBST(midNode.next);
        return root;
    }
}
