package org.algorithm.stack;

import java.util.Stack;

/**
 * 962
 * if i<j then nums[i]<=nums[j] width = j-i
 * return max width
 * */
public class MaxWidthRamp {

    public int maxWidthRamp(int[] nums) {

        Stack<int[]> stack = new Stack<>();

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new int[] { nums[i], i });
            } else {
                int[] peek = stack.peek();
                if (peek[0] > nums[i]) {
                    stack.push(new int[] { nums[i], i });
                }
            }
        }

        // 更新长度


        for (int k = nums.length - 1; k >= max ; k--) {
            while (!stack.isEmpty()) {
                int[] peek = stack.peek();
                if (peek[0] <= nums[k]) {
                    max = Math.max(max, k - peek[1]);
                    stack.pop();
                } else {
                    break;
                }
            }
        }

        return max;
    }
}
