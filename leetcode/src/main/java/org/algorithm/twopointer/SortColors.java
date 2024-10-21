package org.algorithm.twopointer;

/**
 * 75
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 */
public class SortColors {

    public void sortColors(int[] nums) {

        int l=0;
        int h = nums.length-1;

        int k=0;
        while(k<=h){
            if(nums[k]==0){
                swap(nums,k,l);
                k++;
                l++;
            }else if(nums[k]==2){
                swap(nums,k,h);
                h--;
            }else if(nums[k]==1){
                k++;
            }
        }
    }

    void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
