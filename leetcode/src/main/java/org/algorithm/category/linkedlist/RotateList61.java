package org.algorithm.category.linkedlist;

/**
 * 61
 * 旋转链表
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 */
public class RotateList61 {

    public ListNode rotateRight(ListNode head, int k) {

        if(k==0){
            return head;
        }
        if(head==null){
            return null;
        }


        ListNode headMark = head;
        ListNode fast=head;
        ListNode slow=head;

        // step 1 计算链表长度
        int len = 0;
        while(head!=null){
            len++;
            head=head.next;
        }

        // step2 寻找kthNode
        k = k%len;

        if(k==0){
            return headMark;
        }
        while(fast!=null && k>0){
            fast=fast.next;
            k--;
        }

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }

        // step3 指针变换
        fast.next = headMark;
        ListNode newHead = slow.next;
        slow.next = null;

        return newHead;
    }
}
