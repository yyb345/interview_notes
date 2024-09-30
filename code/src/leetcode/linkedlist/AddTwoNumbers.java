package leetcode.linkedlist;


/**
 * 2
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addListNodeNumbers(0,l1,l2);
    }

    public ListNode addListNodeNumbers(int preSum,ListNode l1, ListNode l2) {

        if(l1==null && l2==null){
            if(preSum>0){
                ListNode listNode = new ListNode(preSum);
                return listNode;
            }else{
                return null;
            }
        }else if(l1!=null && l2==null){
            ListNode listNode = new ListNode((l1.val+preSum)%10);
            listNode.next = addListNodeNumbers((l1.val+preSum)/10,l1.next,null);
            return listNode;
        }else if(l1==null && l2!=null){
            ListNode listNode = new ListNode((l2.val+preSum)%10);
            listNode.next = addListNodeNumbers((l2.val+preSum)/10,null,l2.next);
            return listNode;
        }else {
            ListNode listNode = new ListNode((l1.val+l2.val+preSum)%10);
            listNode.next = addListNodeNumbers((l1.val+l2.val+preSum)/10,l1.next,l2.next);
            return listNode;
        }


    }
}
