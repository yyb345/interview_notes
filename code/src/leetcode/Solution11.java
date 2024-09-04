package leetcode;

import java.util.*;


/**
 * Created by yangyibo
 * Date: 2019/4/4
 * Time: 下午5:04
 */
public class Solution11 {


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

	}
}
