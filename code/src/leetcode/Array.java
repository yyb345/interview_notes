package leetcode;

import java.util.*;

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


	//problem 167. Two Sum II - Input array is sorted
	public static int[] twoSum(int[] numbers, int target) {


		int []result=new int[2];
		int start=0;
		int end=numbers.length-1;
		int t=target/2;
		while(start<end){
			int index=(start+end)/2;
			if((start+end)%2!=0){
				index=index+1;
			}

			int mid=numbers[index];
			if(index>start && index<end){
				if(t<mid){
					end=index;
				}else if(t>mid){
					start=index;
				}else if(t==mid){
					end=index;
					start=end-1;
					break;
				}
			}else{
				break;
			}

		}

		result[0]=start;
		result[1]=end;

		while(result[0]>=0 && result[1]<numbers.length){
			if(numbers[result[0]]+numbers[result[1]]==target){
				break;
			}else if(numbers[result[0]]+numbers[result[1]]>target){
				result[0]=result[0]-1;
			}else if(numbers[result[0]]+numbers[result[1]]<target){
				result[1]=result[1]+1;
			}

		}
		if(result[0]==-1 || result[1]==numbers.length ){
			result[0]=numbers.length-1;
			result[1]=numbers.length;
		}else {
			result[0]=result[0]+1;
			result[1]=result[1]+1;
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


	public String longestCommonPrefix(String[] strs) {

		return longestDFS(strs,0,strs.length);
		//strs[0].indexOf();
	}

	public String longestDFS(String[] strs,int l,int h){

		if(l>h)
			return "";
		if(l==h)
			return strs[l];
		int mid=l+(h-l)/2;
		String ll = longestDFS(strs, l, mid);
		String rr = longestDFS(strs, mid, h);
		return commonPrefix(ll, rr);
	}


	public String  commonPrefix(String a,String b){
		String ret="";
		int end=Math.min(a.length(),b.length());
		for(int i=0;i<end;i++){
			if(a.charAt(i)==b.charAt(i)){
				ret+=a.charAt(i);
				continue;
			}else{
				break;
			}
		}

		return ret;
	}

	public static void main(String []args){
//		int a=1916797311;
//		System.out.println(uniquePaths(51,9));
//		int [][]pairs=new int[][]{{1,2},{2,3},{6,9},{5,7}};
//
//		Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
//
//		for(int i=0;i<pairs.length;i++){
//			for(int j=0;j<pairs[0].length;j++){
//				System.out.print(pairs[i][j]);
//			}
//			System.out.println();
//		}

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
