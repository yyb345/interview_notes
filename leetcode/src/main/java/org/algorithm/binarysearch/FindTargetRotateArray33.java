package org.algorithm.binarysearch;

/**
 * 33
 * 旋转数组搜索数字
 */
public class FindTargetRotateArray33 {

    public int search(int[] nums, int target) {

        int l=0;
        int h = nums.length-1;

        while(l<=h){
            int mid = l +(h-l)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>nums[l]){
                if(nums[l]<=target && nums[mid]>target){
                    h = mid-1;
                }else {
                    l = mid +1;
                }
            }else if(nums[mid]<nums[l]) {
                if(nums[mid]<target && nums[h]>=target){
                    l = mid+1;
                }else{
                    h = mid-1;
                }
            }else {
                l++;
            }
        }

        return -1;
    }
}
