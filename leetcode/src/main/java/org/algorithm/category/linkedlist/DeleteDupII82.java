package org.algorithm.category.linkedlist;

/**
 * 84
 * 删除重复值，重复值不保留
 */
public class DeleteDupII82 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }

        boolean headDup = false;
        while(head.next!=null && head.val==head.next.val){
            head = head.next;
            headDup=true;
        }

        ListNode next = deleteDuplicates(head.next);
        if(headDup){
            return next;
        }

        head.next = next;
        return head;
    }
}
