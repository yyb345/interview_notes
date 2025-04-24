package org.algorithm.category.twopointer;

/**
 * 189
 * 一个排序数组，给定一个K，将后K个数放置到前面
 * [1,2,3,4,5,6,7] K=3
 * => [5,6,7,1,2,3,4]
 * 解法：三步走 1. 0->n-1 两两交换 2. 0->k-1 两两交换 3. k->n-1 两两交换
 */
public class RotateArray189 {
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
