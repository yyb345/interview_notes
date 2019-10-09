package problems;

import java.util.Map;

/**
 * Created by yangyibo
 * Date: 2019/4/2
 * Time: 下午11:31
 */
public class LRU {
	ListNode head;

	LRU(){
		head=new ListNode(-1,-1);
	}

	class ListNode{
		int key;
		int val;
		ListNode next;
		ListNode(int key,int val){
			this.key=key;
			this.val=val;
		}
	}


	void LRUTest(int key){
		boolean noKey=false;
		//
		if(noKey){
			ListNode newKey=new ListNode(key,1);
			newKey.next=head.next;
			head=newKey;
		}else {
			//update value
			//插入头

		}



	}



}
