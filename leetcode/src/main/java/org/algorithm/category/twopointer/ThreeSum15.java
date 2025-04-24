package org.algorithm.category.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15
 * 三数之和
 */
public class ThreeSum15 {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ret = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int target = -nums[i];



            // 去重
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            int l=i+1;
            int h=nums.length-1;

            while(l<h){
                int sum = nums[l]+nums[h];
                if(sum==target){
                    ret.add(Arrays.asList(nums[i],nums[l],nums[h]));
                    while(l+1<nums.length && nums[l]==nums[l+1]){l++;}
                    while(h>0 && nums[h]==nums[h-1]){h--;}
                    l++;
                    h--;
                }else if(sum>target){
                    h--;
                }else {
                    l++;
                }
            }

        }

        return ret;
    }
}
