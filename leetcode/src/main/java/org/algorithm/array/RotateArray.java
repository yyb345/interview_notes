package org.algorithm.array;

/**
 * 189
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {

        k = k % nums.length;

        swap(nums,0,nums.length-1);
        swap(nums,0,k-1);
        swap(nums,k,nums.length-1);
    }

    void swap(int[] nums,int i,int j){
        while(i<j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
