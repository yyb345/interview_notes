package leetcode;

import java.util.*;


/**
 * Created by yangyibo
 * Date: 2019/4/4
 * Time: 下午5:04
 */
public class Solution11 {

	static  class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val=val;
		}
	}

	public ListNode deleteDuplication(ListNode pHead)
	{
		if(pHead==null)
			return null;

		ListNode pre=new ListNode(-1);
		ListNode ret=pre;
		ListNode cur=pHead;

		while(cur!=null){
			if(cur.next!=null && cur.val==cur.next.val){
				int val=cur.val;
				do{
					cur=cur.next;
				}while(cur!=null && cur.val==val);

			}else{
				pre.next=cur;
				pre=cur;
				cur=cur.next;
			}

		}

		pre.next=cur;

		return ret.next;
	}


//	public String replaceSpace(StringBuffer str) {
//
//		for(int i=0;i<str.length();i++){
//			if(str.charAt(i)==' '){
//
//			}
//		}
//	}


	public boolean IsPopOrder(int [] pushA,int [] popA) {
		Stack<Integer> stack=new Stack<>();
		int index=0,i=0;
		while(index<popA.length){
			if(i<pushA.length)
				stack.push(pushA[i++]);

			if(stack.peek()!=popA[index]){
				if(i==pushA.length){
					return false;
				}
			} else{
				while(!stack.isEmpty() && stack.peek()==popA[index]){
					index++;
					stack.pop();
				}
			}
		}

		return true;

	}

	Queue<Integer> left=new PriorityQueue<>(((o1, o2) -> o2-o1));// max heap
	Queue<Integer> right=new PriorityQueue<>(((o1, o2) -> o1-o2));// min heap
	int count=0;
	public void Insert(Integer num) {
		count++;
		if(left.isEmpty()){
			left.add(num);
			return;
		}
		if(count%2==0){
			if(num<left.peek()){
				left.add(num);
				right.add(left.poll());
			}else {
				right.add(num);
			}
		}else {
			if(num<left.peek()){
				left.add(num);
			}else {
				right.add(num);
				left.add(right.poll());
			}
		}

	}

	public Double GetMedian() {
		if(count%2==0){
			return (left.peek()+right.peek())/2.0d;
		}else {
			return left.peek()/1.0d;
		}


	}


	char[] chars=new char[256];
	Queue<Character> charsFlow=new LinkedList<>();

	public void Insert(char ch)
	{
		chars[ch]+=1;
		charsFlow.add(ch);
		while(!charsFlow.isEmpty() && chars[charsFlow.peek()]>1){
			charsFlow.poll();
		}

	}
	//return the first appearence once char in current stringstream
	public char FirstAppearingOnce()
	{

		if(charsFlow.isEmpty())
			return  '#';
		return  charsFlow.peek();

	}

	public static void main(String[] args){

//		ListNode a=new ListNode(1);
//		ListNode b=new ListNode(1);
//		ListNode c=new ListNode(1);
//		ListNode d=new ListNode(2);
//		c.next=d;
//		b.next=c;
//		a.next=b;
		int[] push=new int[]{1,2,3,4,5};
		int[] pop=new int[]{4,5,3,2,1};
		new Solution11().IsPopOrder(push,pop);
	}
}
