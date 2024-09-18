package leetcode.binarysearch;

/**
 * 153
 * 寻找旋转数组最小值
 * [3,4,5,1,2]
 *
 */
public class MinRotateArray {

    public int findMin(int[] nums) {

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

        return nums[h];
    }
}
