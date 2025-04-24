package org.algorithm.category.linkedlist;

public class FindKthToTail {

    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode fast = head;
        int iter = k;
        while (iter-- > 0 && fast != null) {
            fast = fast.next;
        }

        if (iter > 0)
            return null;
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
