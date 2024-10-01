package org.algorithm.dp;

public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        int n = nums.length;
        int[] F = new int[n];

        for(int i=0;i<n;i++){
            F[i]=1;
        }

        int max = 1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    F[i]= Math.max(F[j]+1,F[i]);
                    max = Math.max(max,F[i]);
                }
            }


        }

        return max;
    }
}
