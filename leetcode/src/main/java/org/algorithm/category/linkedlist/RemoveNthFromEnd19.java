package org.algorithm.category.linkedlist;


import org.algorithm.ListNode;

/**
 * leetcode 19
 */
public class RemoveNthFromEnd19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head==null){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for(int i=0;i<n;i++){
            fast = fast.next;
        }

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }

        ListNode next = slow.next.next;
        slow.next = next;

        return dummy.next;
    }
}
