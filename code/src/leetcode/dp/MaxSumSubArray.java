package leetcode.dp;


// 重写下
public class MaxSumSubArray {


    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }

        int[] dp = new int[nums.length];

        int sum=nums[0];
        int max=nums[0];
        dp[0]=nums[0];

        for(int i=1;i<nums.length;i++){
            if(sum>=0){
                dp[i]= Math.max(sum+nums[i],dp[i-1]);
                sum = sum+nums[i];
            }else {
                dp[i]= Math.max(nums[i],dp[i-1]);
                sum = nums[i];
            }
            max = Math.max(dp[i],max);
        }

        return dp[nums.length-1];
    }

}
