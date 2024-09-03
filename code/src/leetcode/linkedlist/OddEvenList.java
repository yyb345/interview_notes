package leetcode.linkedlist;


public class OddEvenList {

    public static ListNode oddEvenList(ListNode head) {
        if (head != null) {
            ListNode odd = head;
            ListNode even = head.next;
            ListNode startOdd = odd;
            ListNode startEven = even;

            while (odd != null && even != null) {
                // 下一次迭代
                ListNode nextOdd = null;
                ListNode nextEven = null;
                if (odd.next != null) {
                    nextOdd = odd.next.next;
                    odd.next = odd.next.next;
                } else {
                    break;
                }

                if (even.next != null) {
                    nextEven = even.next.next;
                    even.next = even.next.next;
                } else {
                    break;
                }

                odd = nextOdd;
                even = nextEven;
            }

            odd.next = startEven;
            return startOdd;
        } else {
            return null;
        }

    }
}
