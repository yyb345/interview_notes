package org.algorithm.binarysearch;


//TODO
public class SearchInsert {

    public static int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (nums[middle] > target) {
                end = middle - 1;
            } else if (nums[middle] < target) {
                start = middle + 1;
            } else if (nums[middle] == target) {
                return middle;
            }
        }

        return start;
    }
}
