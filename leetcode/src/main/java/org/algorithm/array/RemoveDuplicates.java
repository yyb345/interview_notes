package org.algorithm.array;

/**
 * 26
 *
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int l=0;
        int num=nums[l];
        int h = 1;

        for(;h<nums.length;h++){
            if(nums[h]!=num){
                nums[l+1]=nums[h];
                num = nums[h];
                l++;
            }
        }

        return l+1;
    }
}
