package org.algorithm.sort;

import java.util.Arrays;

/**
 *179
 *  最大的数
 *  Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        String[] list = new String[nums.length];
        for (int i=0;i<nums.length;i++) {
            list[i]=String.valueOf(nums[i]);
        }

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
}
