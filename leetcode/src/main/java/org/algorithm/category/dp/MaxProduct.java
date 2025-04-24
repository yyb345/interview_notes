package org.algorithm.category.dp;

public class MaxProduct {

    public static int maxProduct(int[] nums) {

        int[][] dp = new int[nums.length][nums.length];
        dp[0][0]=nums[0];
        int maxVal=dp[0][0];

        for(int i=1;i<nums.length;i++){
            maxVal = Math.max(maxVal,nums[i]);
            for(int j=0;j<i;j++){
                dp[j][i]=dp[j][i-1]*nums[i];
                maxVal = Math.max(maxVal,dp[j][i]);
            }
        }

        return maxVal;
    }
}
