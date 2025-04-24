package org.algorithm.category.dp;


/**
 * leetcode 2708 子数组 乘积最大，本质上是一个动态规划问题，前置状态preMin preMax
 */
public class MaxMutiplyTest {

    public static long maxStrength(int[] nums) {


        Long preMax = (long)nums[0];
        Long preMin =(long) nums[0];
        for(int i=1;i<nums.length;i++){

            long max = 0;
            long min = 0;
            if(nums[i]>0){
                if(preMax>0) max= preMax*nums[i];
                if(preMin<0) preMin = preMin*nums[i];
            }else if(nums[i]<0) {
                if(preMin<0) max = preMin * nums[i];
                if(preMax>0) min = preMax* nums[i];
            }else{
                max = Math.max(0,preMax);
                min = Math.min(0,preMin);
            }

            preMax = Math.max(Math.max(nums[i],max),preMax);
            preMin = Math.min(Math.min(nums[i],min),preMin);
        }

        return preMax;
    }

    public static void main(String[] args) {
        System.out.println(maxStrength(new int[]{-4,-5,-4}));
        System.out.println(maxStrength(new int[]{3,-1,-5,2,5,-9}));
        System.out.println(maxStrength(new int[]{0,0,1}));
    }
}
