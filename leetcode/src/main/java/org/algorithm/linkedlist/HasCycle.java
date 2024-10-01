package org.algorithm.linkedlist;

/**
 * 链表是否有环 2024-09-03 review 整理
 */
public class HasCycle {

    public static boolean hasCycle(ListNode head) {

        boolean result=false;
        ListNode slow=head;
        ListNode fast=head;


        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast!=null && slow.val==fast.val){
                result=true;
                break;
            }
        }

        return result;
    }
}
