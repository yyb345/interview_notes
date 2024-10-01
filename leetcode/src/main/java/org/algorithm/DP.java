package org.algorithm;

/**
 * Created by yangyibo
 * Date: 2019/6/2
 * Time: 下午4:56
 */
public class DP {

	public  static  int wiggleMaxLength(int[] nums) {
		if(nums==null || nums.length==0)
			return 0;
		int n=nums.length;
		if(n<=2)
			return n;


		int[] dp=new int[n];
		boolean[] up=new boolean[n];


		dp[0]=1;
		up[1]= nums[1]-nums[0]>0?true:false;
		dp[1]=2;
		int ret=0;


		for(int i=2;i<n;i++){

			int max=0;
			for(int j=0;j<i;j++){
				if(j>0){
					if((up[j] && nums[i]-nums[j]<0) || (!up[j] && nums[i]-nums[j]>0)) {
						if(dp[j]+1>max){
							up[i]=!up[j];
							max=dp[j]+1;
						}
					}
				}else if(j==0){
					up[i]=nums[i]-nums[j]>0?true:false;
					if(dp[j]+1>max){
						up[i]=!up[j];
						max=dp[j]+1;
					}
				}

			}
			dp[i]=max;
			ret=Math.max(dp[i],ret);
		}

		return ret;

	}


	/**
	 * 0 1 背包问题
	 * @param W
	 * @param N
	 * @param weights
	 * @param values
	 * @return
	 */
	public int knapsack(int W, int N, int[] weights, int[] values) {

		int[] dp=new int[W+1];

		for(int i=1;i<=N;i++){
			int w=weights[i-1];
			int val=values[i-1];
			for(int j=W;j>=1;j--){
				if(j>=w){
					dp[j]=Math.max(dp[j],dp[j-w]+val);
				}
			}
		}
		return dp[W];
	}

	public static void main(String[] args){

	}
}
