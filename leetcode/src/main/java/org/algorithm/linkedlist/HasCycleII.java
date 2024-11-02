package org.algorithm.linkedlist;

/**
 * 142
 */
public class HasCycleII {

    public ListNode detectCycle(ListNode head) {

        if(head==null || head.next==null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // 快慢指针两个节点是否会相遇
        do{
            fast = fast.next.next;
            slow = slow.next;
        }while(fast!=null && fast.next!=null && slow!=fast);

        // 不存在环
        if(slow!=fast){
            return null;
        }

        // 寻找环的起点
        ListNode start = head;
        while(start!=fast){
            start = start.next;
            fast  = fast.next;
        }

        return start;
    }
}
