package org.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by yangyibo
 * Date: 2018/12/15
 * Time: 下午10:45
 */
public class Array {

//problem 283
	public static void moveZeroes(int[] nums) {

		int replaceIndex=0;
		int zeroNum=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]!=0){
				int tmp=nums[i];
				nums[i]=nums[replaceIndex];
				nums[replaceIndex]=tmp;
				replaceIndex++;
			}else{
				if(zeroNum==0){
					replaceIndex=i;
				}

				zeroNum++;
			}
		}

		for(int j=0;j<nums.length;j++){
			System.out.print(" "+nums[j]);
		}
		System.out.println();
	}

	// problem 268
	public static int missingNumber(int[] nums) {
		int result=0;
		int i=0;
		while(i<nums.length){
			while(nums[i]>0 && nums[i]!=(i+1)){
				int tmp=nums[i];
				nums[i]=nums[nums[i]-1];
				nums[tmp-1]=tmp;
			}
			i++;
		}
		for(int j=0;j<nums.length;j++){
			if(nums[j]==0){
				result=j+1;
				break;
			}
		}



		return result;
	}
	// problem 442
	public static List<Integer> findDuplicates(int[] nums) {
		int []index=new int[nums.length];
		List<Integer> result=new ArrayList();
		for(int i=0;i<nums.length;i++){
			if(index[nums[i]-1]==1)
				result.add(nums[i]);
			else
				index[nums[i]-1]=1;
		}
		return result;
	}

	// problem 260. Single Number III
	public static int[] xx(int nums[]){
		// Pass 1 :
		// Get the XOR of the two numbers we need to find
		int diff = 0;
		for (int num : nums) {
			diff ^= num;
		}
		// Get its last set bit
		diff &= -diff;


		// Pass 2 :
		int[] rets = {0, 0}; // this array stores the two numbers we will return
		for (int num : nums)
		{
			if ((num & diff) == 0) // the bit is not set
			{
				rets[0] ^= num;
			}
			else // the bit is set
			{
				rets[1] ^= num;
			}
		}
		return rets;
	}

	// problem 88
	public static void merge(int[] nums1, int m, int[] nums2, int n) {

		int []newArray=new int[m+n];
		int index1=0,index2=0;
		while(index1<m ||index2<n){
			if(index1==m){
				newArray[index1+index2]=nums2[index2++];
			}else if(index2==n){
				newArray[index1+index2]=nums1[index1++];
			}else{
				if(nums2[index2]>nums1[index1]){
					newArray[index1+index2]=nums1[index1++];
				}else{
					newArray[index1+index2]=nums2[index2];
				}
			}


		}
		for(int i=0;i<newArray.length;i++){
			nums1[i]=newArray[i];
		}

	}



	public static boolean containsDuplicate(int[] nums) {

		boolean result=false;
		if(Arrays.stream(nums).distinct().toArray().length!=nums.length){
			result=true;
		}



		return result;

	}

	// problem
	public static int uniquePaths(int m, int n) {
		int [][]value=new int[m+1][n+1];
		value[1][0]=0;
		value[0][1]=1;
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				value[i][j]=value[i-1][j]+value[i][j-1];
			}
		}

		return value[m][n];

	}


	public static  boolean  isMonotonic(int[] A) {

		if(A.length==1){
			return true;
		}else{
			int index=1;
			boolean up=false;
			while(index<A.length){
				if(A[index-1]<A[index]){
					up=true;
					break;
				}else if(A[index-1]>A[index]){
					up=false;
					break;
				}
				index++;
			}

			if(up){
				while(index<A.length){
					if(A[index-1]>A[index])
						break;
					index++;
				}

			}else{
				while(index<A.length){
					if(A[index-1]<A[index])
						break;
					index++;
				}
			}


			return index==(A.length);



		}

	}


	public int evalRPN(String[] tokens) {

		if(tokens==null || tokens.length==0)
			return 0;

		Stack<Integer> stack=new Stack<>();
		for(String s:tokens){
			if(s.equals("+")){
				int pop1 = stack.pop();
				int pop2 = stack.pop();
				stack.push(pop1+pop2);
			}else if(s.equals("-")){
				int pop1 = stack.pop();
				int pop2 = stack.pop();
				stack.push(pop1-pop2);

			}else if(s.equals("*")){
				int pop1 = stack.pop();
				int pop2 = stack.pop();
				stack.push(pop1*pop2);
			}else if(s.equals("/")){

				int pop1 = stack.pop();
				int pop2 = stack.pop();
				stack.push(pop2/pop1);
			}else{
				stack.push(Integer.parseInt(s));
			}

		}

		return  stack.pop();

	}


	public static void main(String []args){

		String[] strs=new String[]{"bb","aaa","aaaa"};
		String pre = strs[0];
		int i = 1;
		while(i < strs.length){
			while(strs[i].indexOf(pre) != 0)
				pre = pre.substring(0,pre.length()-1);
			i++;
		}
		System.out.println( pre);


		System.out.println("b".indexOf(""));
	}
}
