package org.algorithm.linkedlist;

/**
 * leetcode 141
 * 链表是否有环 2024-09-03 review 整理
 * 2025-04-10 笔记更新
 * 时间复杂度 O(n)  空间复杂度O(1)
 */
public class HasCycle141 {

    public static boolean hasCycle(ListNode head) {
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
