package org.algorithm.binarysearch;


/**
 * 35
 * 测试用例
 * [1] 1,0,2
 * [1,4] 2,0,5
 * return l 或 h+1
 */
public class SearchInsert35 {

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

    public static void main(String[] args) {

        System.out.println(searchInsert(new int[]{1},0));
        System.out.println(searchInsert(new int[]{1},1));
        System.out.println(searchInsert(new int[]{1},2));
        System.out.println(searchInsert(new int[]{1,4},0));
        System.out.println(searchInsert(new int[]{1,4},2));
        System.out.println(searchInsert(new int[]{1,4},5));
    }
}
