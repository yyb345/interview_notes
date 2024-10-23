package org.algorithm.array;

/**
 * 26
 *
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        int num=nums[0];
        int l=1;
        int h = 1;

        for(;h<nums.length;h++){
            if(nums[h]!=num){
                nums[l++]=nums[h];
                num = nums[h];
            }
        }

        return l;
    }
}
