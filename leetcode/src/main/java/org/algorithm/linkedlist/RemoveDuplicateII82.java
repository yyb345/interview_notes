package org.algorithm.linkedlist;

/**
 * 82
 * 删除重复的值
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 *
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 */
public class RemoveDuplicateII82 {

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
