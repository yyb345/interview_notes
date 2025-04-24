package org.algorithm.category.queue;

import java.util.*;

//TODO
/**
 * /
 * 239
 * 滑动窗口的最大值
 */
public class MaxInWindows {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || nums.length<k){
            return new int[]{};
        }

        int[] ret = new int[nums.length-k+1];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)-> b[0]-a[0]);
        for(int i=0;i<k;i++){
            queue.add(new int[]{nums[i],i});
        }
        ret[0]=queue.peek()[0];

        for(int i=1,j=k;j<nums.length;i++,j++){
            queue.add(new int[]{nums[j],j});
            while(!queue.isEmpty() && queue.peek()[1]<j-k+1){
                queue.poll();
            }
            ret[i]=queue.peek()[0];
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new MaxInWindows().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3));
    }
}
