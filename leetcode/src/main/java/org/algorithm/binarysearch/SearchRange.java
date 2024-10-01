package org.algorithm.binarysearch;

//TODO
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return new int[]{-1,-1};
        }


        int l = 0;
        int h = nums.length-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(nums[mid]>target){
                h = mid-1;
            }else if(nums[mid]<target){
                l = mid+1;
            }else if(nums[mid]==target){
                // find end
                int end=mid;
                while(end<nums.length && nums[end]==target ){
                    end++;
                }

                int[] F = new int[2];
                F[1]=Math.max(end-1,0);
                // find start
                int start = mid;
                while(start>0 && nums[start]==target){
                    start--;
                }
                F[0]=start+1;
                return F;
            }
        }

        return new int[]{-1,-1};
    }
}
