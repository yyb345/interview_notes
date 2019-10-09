package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyibo
 * Date: 2019/4/1
 * Time: 下午3:36
 */
class Solution3 {
	public int findKthLargest(int[] nums, int k) {

		k=nums.length-k;
		int l=0,h=nums.length-1;

		while(true){
			int index=partition(nums,l,h);
			if(index<k)
				l=index+1;
			else if(index>k)
				h=index-1;
			else if(index==k)
				break;
		}

		return nums[k];

	}

	public int partition(int[] nums,int l,int h){

		int i=l,j=h+1;

		while(i<j){
			while(nums[++i]<nums[l] && i<h);
			while(nums[--j]>nums[l] && j>l);
			swap(nums,i,j);
		}
		swap(nums,l,j);
		return j;
	}

	public void swap(int[] nums,int i,int j){
		int tmp=nums[i];
		nums[i]=nums[j];
		nums[j]=tmp;
	}

	public int numDecodings(String s) {

		if(s==null || s.length()==0)
			return 0;
		int[] dp=new int[s.length()+1];
		dp[0]=1;
		if(s.charAt(0)!='0')
			dp[1]=1;
		else
			dp[1]=0;

		for(int i=2;i<=s.length();i++){


			if((i-2)>=0){
				if(s.charAt(i-1)!='0')
					dp[i]+=dp[i-1];
				if(s.charAt(i-2)!='0'){
					String ss=s.charAt(i-2)+""+s.charAt(i-1);
					int num=Integer.parseInt(ss);
					if(num>=1 && num<=26)
						dp[i]+=dp[i-2];
				}


			}



		}

		return dp[s.length()];
	}


	public void reOrderArray(int [] array) {
		List<Integer> odd=new ArrayList<>();
		List<Integer> even=new ArrayList<>();
		for(int i=0;i<array.length;i++){
			if(array[i]%2==0){
				even.add(array[i]);
			}else{
				odd.add(array[i]);
			}
		}

		int index1=0;
		while(index1<odd.size()){
			array[index1]=odd.get(index1);
			index1++;
		}
		int index2=0;
		while((index2)<even.size()){
			array[index2+index1]=even.get(index2);
		}




	}

//	public ListNode FindKthToTail(ListNode head,int k) {
//		if(head==null)
//			return null;
//		ListNode fast=head;
//		int iter=k;
//		while(iter-- >0 && fast!=null){
//			fast=fast.next;
//		}
//
//		if(iter>0)
//			return null;
//		ListNode slow=head;
//		while(fast!=null){
//			slow=slow.next;
//			fast=fast.next;
//		}
//
//		return slow;
//
//
//	}


	public static void main(String[] args){
		new Solution3().numDecodings("12");
	}
}
