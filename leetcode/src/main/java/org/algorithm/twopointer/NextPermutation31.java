package org.algorithm.twopointer;

/**
 * 31 数组的下一次排列
 * [1,2,3]-->[1,3,2]
 * 解法：1. 从尾部向左找第一个下降的点n，然后再返回尾部找到比它大的最小的点m 2.两点交换
 *      3. 尾部到n点之间的重新排序成最小的数组【因为本身是下降的，所以只需要两两交换就可以了】
 *  时间复杂度 O(N) 空间复杂度 O(1)
 */
public class NextPermutation31 {

    public void nextPermutation(int[] nums) {

        // right-->left find nums[right]>nums[left] then swap
        int h = nums.length-1;
        int t = h-1;
        boolean find = false;
        for(h=nums.length-1;h>=1;h--){
            if(nums[h]>nums[h-1]){
                find = true;
                break;
            }
        }

        int r = nums.length-1;
        int l = 0;
        if(find){
            // find minVal that greater than nums[h-1];
            int greaterIndex = h;
            for(int rr=nums.length-1;rr>=h;rr--){
                if(nums[rr]>nums[h-1]){
                    greaterIndex = rr;
                    break;
                }
            }
            swap(nums,h-1,greaterIndex);
            l = h;
        }

        // swap all element
        while(l<r){
            swap(nums,r--,l++);
        }

    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
