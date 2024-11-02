package org.algorithm.linkedlist;

/**
 * 725
 */
public class SplitKList {

    public ListNode[] splitListToParts(ListNode head, int k) {

        if(head==null){
            return new ListNode[k];
        }

        ListNode[] ret = new ListNode[k];

        // 计算链表长度
        int n = getListNodeLen(head);

        // 每组元素个数
        int m = n/k;
        int remain = n%k;

        ListNode iter = head;
        int t=0;
        int j=0;
        while(iter!=null){

            ListNode addNode= new ListNode(-1);
            ListNode addHead = addNode;
            int size = t<remain?m+1:m;
            t++;
            for(int i=0;i<size;i++){
                addNode.next = new ListNode(iter.val);
                addNode = addNode.next;
                iter=iter.next;
            }

            // 添加元素
            ret[j++]=addHead.next;
        }

        return ret;
    }

    int getListNodeLen(ListNode head){
        ListNode iter = head;
        int len=0;
        while(iter!=null){
            len++;
            iter = iter.next;
        }

        return len;
    }
}
