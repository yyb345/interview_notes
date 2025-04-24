package org.algorithm.category.greedy;

/**
 * 334
 */
public class IncreaseTripleNums {

    public boolean increasingTriplet(int[] nums) {


        int ii=Integer.MAX_VALUE;
        int jj=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>jj){
                return true;
            }else if(nums[i]>ii){
                jj = Math.min(jj,nums[i]);
            }else {
                ii = Math.min(ii,nums[i]);
            }
        }

        return false;
    }
}
