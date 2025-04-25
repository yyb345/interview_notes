package org.algorithm.category.linkedlist;


import org.algorithm.ListNode;

public class DeleteNode {

    public ListNode deleteNode(ListNode head, int val) {
        if(head==null){
            return null;
        }
        ListNode curNode = head;
        if(curNode.val==val){
            return curNode.next;
        }

        while(curNode.next!=null){
            if(curNode.next.val==val){
                ListNode next = curNode.next.next;
                curNode.next= next;
                break;
            }
            curNode=curNode.next;
        }
        return head;
    }
}
