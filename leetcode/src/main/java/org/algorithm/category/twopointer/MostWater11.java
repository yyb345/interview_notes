package org.algorithm.category.twopointer;

/**
 * 11
 * 时间复杂度O(N) 空间复杂度O(1)
 */
public class MostWater11 {
    public int maxArea(int[] height) {

        int l = 0;
        int h = height.length-1;

        int max=0;
        while(l<h){
            int minHeight=Math.min(height[l],height[h]);
            max = Math.max(max,minHeight*(h-l));
            if(minHeight==height[l]){
                l++;
            }else if(minHeight==height[h]){
                h--;
            }
        }
        return max;
    }
}
