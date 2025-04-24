package org.algorithm.category.binarysearch;

/**
 * 81
 * 有重复值
 */
public class FindTargetRotateArrayII81 {

    public boolean search(int[] nums, int target) {


        // uuuudddd
        int l=0;
        int h = nums.length-1;

        // 1. find minIndex
        while(l<=h){
            int mid = l +(h-l)/2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[mid]>nums[l]){
                if(nums[l]<=target && nums[mid]>target){
                    h = mid-1;
                }else {
                    l = mid +1;
                }
            }else if(nums[mid]<nums[l]){
                if(nums[mid]<target && nums[h]>=target){
                    l = mid+1;
                }else{
                    h = mid-1;
                }
            }else {
                // 重复，去重,缩短区间
                l++;
            }
        }

        return false;
    }
}
