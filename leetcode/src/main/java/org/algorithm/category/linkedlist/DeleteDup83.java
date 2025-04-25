package org.algorithm.category.linkedlist;

import org.algorithm.ListNode;

/**
 * 83
 * 删除重复值，重复值保留一个
 */
public class DeleteDup83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        if(head.val==head.next.val){
            head=deleteDuplicates(head.next);
        }else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
}
