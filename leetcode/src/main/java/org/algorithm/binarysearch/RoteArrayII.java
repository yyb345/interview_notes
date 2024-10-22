package org.algorithm.binarysearch;

public class RoteArrayII {

    public boolean search(int[] nums, int target) {


        // uuuudddd
        int l=0;
        int h = nums.length-1;

        // 1. find minIndex
        while(l<h){
            int mid = l +(h-l)/2;
            if(nums[mid]==nums[h]){

            } else if(nums[mid]>nums[h]){
                l = mid+1;
            }else {
                h = mid;
            }
        }

        int minIndex = l;

        // 2. find target in  2 phase nums
        return findBinarySearch(nums,0,minIndex-1,target) || findBinarySearch(nums,minIndex,h,target);
    }

    boolean findBinarySearch(int[] nums,int l,int h,int target){
        int ll=l;
        int hh=h;
        while(ll<=hh){
            int mid = ll + (hh-ll)/2;
            if(nums[mid]==target){
                return true;
            }else if(nums[mid]>target){
                hh=mid-1;
            }else {
                ll = mid+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new RoteArrayII().search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1},1);
    }
}
