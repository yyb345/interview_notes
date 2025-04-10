package org.algorithm.linkedlist;

/**
 * 83
 */
public class DeleteDuplicates83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        if(head.val==head.next.val){
            head=deleteDuplicates(head.next);
        }else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
}
