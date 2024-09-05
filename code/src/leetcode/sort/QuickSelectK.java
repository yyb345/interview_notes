package leetcode.sort;
/**
 * 12
 *
 */
import java.util.*;
public class QuickSelectK {
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> ret=new ArrayList<>();
		if(input==null)
			return ret;

		getK(input,k-1);
		for(int i=0;i<k;i++){
			ret.add(input[i]);
		}
		return ret;
	}


	public void getK(int[] nums,int k){

		int i=0,j=nums.length-1;
		while(i<j){
			int t=partition(nums,i,j);
			if(t>k){
				j=t-1;
			}else if(t<k){
				i=t+1;
			}else if(t==k){
				return;
			}
		}
	}


	public int partition(int[] nums,int l,int h){
		int i=l,j=h+1;

		while(true){
			while(i!=h && nums[++i]<nums[l] );
			while(j!=l && nums[--j]>nums[l] );
			if(i>=j)
				break;
			swap(nums,i,j);
		}

		swap(nums,l,j);
		return j;
	}


	public  void swap(int[] nums,int i,int j){
		int tmp=nums[i];
		nums[i]=nums[j];
		nums[j]=tmp;
	}

	public static void main(String[] args){
		int[] inputs=new int[]{4,5,1,6,2,7,3,8};
		new QuickSelectK().GetLeastNumbers_Solution(inputs,10);
	}
}
