package org.algorithm.greedy;

/**
 * leetcode 55
 * 解法：贪心算法
 * 时间复杂度 O(N) 空间复杂度 O(1)
 */
public class JumpGame55 {
    public boolean canJump(int[] nums) {

        int max=0;
        for(int i=0;i<=max && i<nums.length;i++){
            max = Math.max(max,nums[i]+i);
            if(max>=(nums.length-1)){
                return true;
            }
        }

        return false;
    }
}
