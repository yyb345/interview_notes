package org.algorithm.category.linkedlist;


/**
 * 2
 * 解法：双指针+链表
 * 时间复杂度O(N) 空间复杂度O(1)
 */
public class AddTwoNumbers2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    ListNode add(ListNode l1, ListNode l2, int sum) {

        if (l1 == null && l2 == null) {
            return sum > 0 ? new ListNode(1) : null;
        }
        int val = sum;
        val += (l1 != null ? l1.val : 0);
        val += (l2 != null ? l2.val : 0);
        ListNode node = new ListNode(val%10);
        node.next = add(l1 != null ? l1.next : null, l2 != null ? l2.next : null, val/10);
        return node;
    }
}
