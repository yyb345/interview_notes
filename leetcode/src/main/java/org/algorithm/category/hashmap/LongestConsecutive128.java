package org.algorithm.category.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * 128
 * 一个数组，寻找连续的数的最大长度
 * 解法：集合
 */
public class LongestConsecutive128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++) set.add(nums[i]);
        int max = 0;
        for(Integer num:nums){
            int left = num-1;
            int right = num+1;
            while(set.remove(left)){ left--;}
            while(set.remove(right)){ right++;}
            max= Math.max(max,right-left-1);
            if(set.isEmpty()) return max;
        }

        return max;
    }
}
