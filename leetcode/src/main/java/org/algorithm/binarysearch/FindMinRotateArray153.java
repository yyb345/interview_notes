package org.algorithm.binarysearch;

/**
 * 153
 * 寻找旋转数组最小值
 * [1]
 * [2,1]
 * [2,3,1]
 * 返回nums[l] nums[h] 都可以
 */
public class FindMinRotateArray153 {

    public static int findMin(int[] nums) {

        int l=0;
        int h= nums.length-1;

        while(l<h){
            int mid = l + (h-l)/2;
            if(nums[mid]>nums[h]){
                l = mid+1;
            }else {
                h = mid;
            }
        }

        return nums[l];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{1}));
        System.out.println(findMin(new int[]{2,1}));
        System.out.println(findMin(new int[]{2,3,1}));

    }
}
