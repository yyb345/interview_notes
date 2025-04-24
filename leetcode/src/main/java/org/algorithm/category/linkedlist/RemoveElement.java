package org.algorithm.category.linkedlist;

/**
 * 203
 */
public class RemoveElement {

    public ListNode removeElements(ListNode head, int val) {

        if(head==null){
            return null;
        }

        ListNode next = removeElements(head.next,val);
        if(head.val==val){
            return next;
        }else {
            head.next = next;
            return head;
        }
    }
}
