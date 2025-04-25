package org.algorithm.category.linkedlist;

import org.algorithm.ListNode;

/**
 * leetcode 21
 * 两个链表是排序的，合并为新的合并的链表
 */
public class MergeTwoLists21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){return list2;}
        if(list2==null){return list1;}

        ListNode newHead = null;
        if(list1.val<=list2.val){
            newHead = new ListNode(list1.val);
            newHead.next = mergeTwoLists(list1.next,list2);
        }else {
            newHead = new ListNode(list2.val);
            newHead.next = mergeTwoLists(list1,list2.next);
        }
        return newHead;
    }
}
