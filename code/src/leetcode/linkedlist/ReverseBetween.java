package leetcode.linkedlist;

import leetcode.Solution;

public class ReverseBetween {

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode iter = head;
        ListNode pre = null;
        ListNode middle = null;
        ListNode tail = null;
        int index = 1;
        while (iter != null) {
            if (index == m - 1) {
                pre = iter;
            }

            if (index >= m && index <= n) {
                ListNode tmp = new ListNode(iter.val);
                tmp.next = middle;
                middle = tmp;
                if (index == m) {
                    tail = middle;
                }
            }

            if (index == n + 1) {
                break;
            }


            iter = iter.next;
            index++;

        }

        if (pre != null) {
            pre.next = middle;
        } else {
            head = middle;
        }
        tail.next = iter;

        return head;

    }
}
