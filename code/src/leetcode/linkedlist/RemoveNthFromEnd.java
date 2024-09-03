package leetcode.linkedlist;


public class RemoveNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head != null) {

            ListNode iter = head;
            ListNode second = head;
            ListNode pre = head;

            int i = 1;
            while (second != null && i < n) {
                second = second.next;
                i++;
            }


            int j = 0;
            while (second != null && second.next != null) {
                second = second.next;
                iter = iter.next;

                if (j > 0) {

                    pre = pre.next;
                } else
                    j++;
            }
            if (j > 0)
                pre.next = iter.next;
            else
                head = head.next;
        }


        return head;
    }
}
