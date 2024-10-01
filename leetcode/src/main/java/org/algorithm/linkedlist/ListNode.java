package org.algorithm.linkedlist;

public class ListNode {

    public int val;
    public ListNode next;


    ListNode(int val){
        this.val = val;
    }


    public static ListNode bulidListNode(int[] nums){

        ListNode preHead = new ListNode(-1);
        ListNode retHead= preHead;
        for(int num:nums){
            preHead.next = new ListNode(num);
            preHead = preHead.next;
        }
        return retHead.next;
    }

    public static void  printListNode(ListNode head){
        while(head!=null){
            System.out.print(head.val+",");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        ListNode listNode = bulidListNode(new int[]{1, 2, 3, 4, 5, 6});
        printListNode(listNode);
    }
}
