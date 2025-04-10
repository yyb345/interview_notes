package org.algorithm.linkedlist;

/**
 *142
 * 2025-04-10 笔记更新
 * 时间复杂度 O(n)
 * 空间复杂度 O(1)
 * 2(a+b) = a+b+c+b => 推导出a=c
 * 解题步骤：1. 确定是否有环 2. slow指针从head开始 fast指针从相交处开始，下一次相交点就是环的起点
 */
public class HasCycleII142 {

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
