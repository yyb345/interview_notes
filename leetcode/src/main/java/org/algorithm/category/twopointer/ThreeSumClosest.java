package org.algorithm.category.twopointer;

import java.util.Arrays;

/**
 * 16
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int minClosedSum =0;
        int minDiff = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){

            int l = i+1;
            int h = nums.length-1;

            while(l<h){
                if(Math.abs(nums[i]+nums[l]+nums[h]-target)<minDiff){
                    minClosedSum = nums[i]+nums[l]+nums[h];
                    minDiff=Math.abs(nums[i]+nums[l]+nums[h]-target);
                }
                if((nums[i]+nums[l]+nums[h])<target){
                    l++;
                }else if((nums[i]+nums[l]+nums[h])>target){
                    h--;
                }else {
                    return target;
                }
            }
        }
        return minClosedSum;
    }
}
