package org.algorithm.dp;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        int m = nums.length;
        int[] F = new int[m];
        F[0]=1;
        for (int num : nums) {
            set.add(num);
        }

        for(int i=1;i<m && !set.isEmpty();i++){
            int num=1;
            int current= nums[i];
            while(set.contains(--current)){
                num++;
                set.remove(current);
            }
            current= nums[i];
            while(set.contains(++current)){
                num++;
                set.remove(current);
            }

            F[i]=Math.max(num,F[i-1]);

        }

        return F[m-1];
    }
}
