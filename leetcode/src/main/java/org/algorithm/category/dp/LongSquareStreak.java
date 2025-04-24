package org.algorithm.category.dp;

import java.util.Arrays;

/**
 * 2501
 * Input: nums = [4,3,6,16,8,2]
 * Therefore, [4,16,2] is a square streak. len = 3
 * Sort + DP
 */
public class LongSquareStreak {

    public static int longestSquareStreak(int[] nums) {

        // 排序 + DP
        int maxValue = 1;
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=1;i<nums.length;i++){
            int sqrt = (int) Math.sqrt(nums[i]);
            if(sqrt*sqrt!=nums[i]){
                continue;
            }
            int j = Arrays.binarySearch(nums, 0, i , sqrt);
            if(j>=0){
                dp[i]=dp[j]+1;
                maxValue = Math.max(maxValue,dp[i]);
            }
        }

        return maxValue>=2 ? maxValue:-1;
    }
}
