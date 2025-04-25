package org.algorithm.order;

/**
 * 45
 * 最小的迭代步数
 * 解题：贪心算法，每次迭代最多能跑多远
 */
public class LC45 {
    public int jump(int[] nums) {

        int step = 0;
        int start = 0;
        int end = 0;
        int maxEnd = 0;
        while (true) {

            // 判断是否已经满足条件
            if (maxEnd >= (nums.length - 1)) {
                break;
            }
            // 一轮迭代最远到那个地方
            for (int i = start; i <= end; i++) {
                maxEnd = Math.max(nums[i] + i, maxEnd);
            }
            // 迭代步数+1
            step++;
            start = end + 1;
            end = maxEnd;
        }
        return step;
    }
}
