package org.algorithm.array;

/**
 * 169
 * 找出超过一般的元素
 */
public class MajorityNum {

    public int majorityElement(int[] nums) {
        int major=0;
        int count = 0;
        for(int num:nums){
            if(count==0) {
                major = num;
                count++;
                continue;
            }

            if(major!=num){
                count--;
            }else {
                count++;
            }
        }

        return major;
    }
}
