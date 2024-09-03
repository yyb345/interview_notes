package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yangyibo
 * Date: 2018/12/12
 * Time: 上午12:21
 */


public class LinkedListSolution {

	 public static  class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }


	public void deleteNode(ListNode node) {

	}

	public static boolean hasCycle(ListNode head) {

	 	boolean result=false;
		ListNode slow=head;
		ListNode fast=head;


		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(fast!=null && slow.val==fast.val){
				result=true;
				break;
			}
		}

		return result;
	}


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


	// 503. Next Greater Element II
	public static int[] nextGreaterElements(int[] nums) {

	 	int []result=new int[nums.length];

		Stack<Integer> value=new Stack<>();
		Stack<Integer> index=new Stack<>();

		for(int i=0;i<nums.length;i++){
			result[i]=-1;
			while(value.size()>0){
				int peek = value.peek();
				if(nums[i]>peek){
					value.pop();
					result[index.pop()]=nums[i];
				}else{
					break;
				}
			}
			value.push(nums[i]);
			index.push(i);
		}

		if(value.size()>0){
			for(int j=0;j<nums.length;j++){
				while(value.size()>0){
					int peek = value.peek();
					if(nums[j]>peek){
						value.pop();
						result[index.pop()]=nums[j];
					}else{
						break;
					}
				}
			}
		}
	 	return result;
	}
}
