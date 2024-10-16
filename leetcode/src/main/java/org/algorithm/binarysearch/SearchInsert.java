package org.algorithm.binarysearch;


/**
 * 35
 */
public class SearchInsert {

    public static int searchInsert(int[] nums, int target) {

        int l = 0;
        int h = nums.length - 1;

        while (l <= h) {
            int middle = l + ( h-l) / 2;
            if (nums[middle] > target) {
                h = middle - 1;
            } else if (nums[middle] < target) {
                l = middle + 1;
            } else if (nums[middle] == target) {
                return middle;
            }
        }

        return l;
    }
}
