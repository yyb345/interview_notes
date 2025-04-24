package org.algorithm.category.array;

/**
 * 80
 */
public class RemoveDuplicatesII {

    public int removeDuplicates(int[] nums) {

        int l = 1;
        int preNum = nums[0];
        int count = 1;

        for(int h=1;h<nums.length;h++){
            count= nums[h]==preNum? count+1:1;
            if(count<=2){
                nums[l++]=nums[h];
            }
            preNum  = nums[h];
        }

        return l;
    }
}
