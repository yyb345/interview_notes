package leetcode.linkedlist;

import leetcode.Solution;

import java.util.Stack;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode first = null;
        //ListNode result=null;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int preSum = 0;

        while (stack2.size() > 0 || stack1.size() > 0) {

            int sum = 0;
            if (stack1.size() > 0) {
                sum += stack1.pop();
            }
            if (stack2.size() > 0) {
                sum += stack2.pop();
            }
            sum += preSum;
            int value = sum % 10;
            preSum = sum / 10;
            ListNode tmp = new ListNode(value);
            tmp.next = first;
            first = tmp;
        }

        if (preSum == 1) {
            ListNode tmp = new ListNode(1);
            tmp.next = first;
            first = tmp;
        }

        return first;

    }
}
