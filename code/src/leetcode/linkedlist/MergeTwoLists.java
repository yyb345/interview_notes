package leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 合并链表 2024-09-03
 */
public class MergeTwoLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode result=null;
        ListNode p1=l1;
        ListNode p2=l2;
        List<Integer> tmp=new ArrayList<>();
        while(p1!=null || p2 !=null){
            if(p1!=null && p2!=null){
                if(p2.val<p1.val){
                    tmp.add(p2.val);
                    p2=p2.next;
                }else if(p2.val>p1.val){
                    tmp.add(p1.val);
                    p1=p1.next;
                }else if(p2.val==p1.val){
                    tmp.add(p1.val);
                    tmp.add(p2.val);
                    p1=p1.next;
                    p2=p2.next;
                }
            }else if(p1!=null && p2==null){
                tmp.add(p1.val);
                p1=p1.next;
            }else if(p1==null && p2!=null){
                tmp.add(p2.val);
                p2=p2.next;
            }
        }

        if(tmp.size()>0) {
            result= new ListNode(tmp.get(0));
        }

        ListNode other = result;
        for (int i = 1; i < tmp.size(); i++) {
            ListNode temp = new ListNode(tmp.get(i));
            other.next = temp;
            other = temp;
        }

        return result;
    }
}
