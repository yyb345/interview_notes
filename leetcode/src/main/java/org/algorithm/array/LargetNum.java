package org.algorithm.array;


import java.util.Arrays;

/**
 * 179
 * 输出最大值
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 */
public class LargetNum {

    public String largestNumber(int[] nums) {

        String[] list = new String[nums.length];
        for (int i=0;i<nums.length;i++) {
            list[i]=String.valueOf(nums[i]);
        }

        // compare lameda 表达式，compareTo 为-1，表示不换位置，否则换位置
        Arrays.sort(list,(a,b)->  (b+a).compareTo(a+b));

        String ret = "";
        for(int i=0;i<list.length;i++){
            ret+=list[i];
        }
        if(ret.charAt(0)=='0'){
            return "0";
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new LargetNum().largestNumber(new int[]{1,8,4}));
    }
}
