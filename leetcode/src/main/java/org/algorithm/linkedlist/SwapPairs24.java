package org.algorithm.linkedlist;

/**
 * leetcode 24
 * 【1,2,3,4】=> [2,1,3,4]
 *  解题思路：递归
 */
public class SwapPairs24 {

    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode next = head.next;
        head.next=swapPairs(next.next);
        next.next= head;
        return next;
    }
}
