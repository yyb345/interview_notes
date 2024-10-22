package org.algorithm.array;

/**
 * 238
 */
public class ProductArray {
    public int[] productExceptSelf(int[] nums) {

        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        int[] ret = new int[nums.length];


        leftProduct[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            leftProduct[i]=leftProduct[i-1]*nums[i];
        }

        rightProduct[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            rightProduct[i]=rightProduct[i+1]*nums[i];
        }


        for(int i=0;i<nums.length;i++){
            if(i==0){
                ret[i]=rightProduct[i+1];
            }else if(i==nums.length-1){
                ret[i]=leftProduct[i-1];
            }else {
                ret[i]=leftProduct[i-1]*rightProduct[i+1];
            }
        }

        return ret;
    }
}
