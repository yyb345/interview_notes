package org.algorithm.category.binarytree.build;

import org.algorithm.category.ListNode;
import org.algorithm.category.binarytree.TreeNode;

/**
 * 109
 * 有序的ListNode转为BST
 * 时间复杂度O(NlogN) 空间复杂度O(1)
 */
public class ListNodeToBST109 {

    public TreeNode sortedListToBST(ListNode head) {
        return toBST(head,null);
    }

    TreeNode toBST(ListNode head,ListNode tail){
        if(head==null){
            return null;
        }
        if(head==tail){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=tail && fast.next!=tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode midNode = slow;
        TreeNode treeNode = new TreeNode(midNode.val);
        treeNode.left=toBST(head,midNode);
        treeNode.right=toBST(midNode.next,tail);
        return treeNode;
    }
}
