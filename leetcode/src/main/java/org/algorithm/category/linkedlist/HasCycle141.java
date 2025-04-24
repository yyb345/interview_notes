package org.algorithm.category.linkedlist;

/**
 * leetcode 141
 * 链表是否有环
 * 时间复杂度 O(n)  空间复杂度O(1)
 */
public class HasCycle141 {

    public  boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}
