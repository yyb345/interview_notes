package org.algorithm.category.binarysearch;

/**
 * 162
 * 寻找峰值
 * [0] [1,2] [1,2,3]
 */
public class FindPeekEle162 {

    public int findPeakElement(int[] nums) {

        int l = 0;
        int h = nums.length-1;

        while(l<h){
            int mid = l +(h-l)/2;
            if(nums[mid]>nums[mid+1]){
                h=mid;
            }else {
                l=mid+1;
            }
        }

        return h;
    }
}
