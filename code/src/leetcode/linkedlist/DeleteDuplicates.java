package leetcode.linkedlist;



public class DeleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head != null) {
            ListNode pre = head;
            ListNode iter = head.next;

            while (iter != null) {
                if (pre.val == iter.val) {
                    pre.next = iter.next;
                    iter = iter.next;
                } else {
                    pre = pre.next;
                    iter = iter.next;
                }
            }
        }
        return head;
    }
}
