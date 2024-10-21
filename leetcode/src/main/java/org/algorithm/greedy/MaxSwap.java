package org.algorithm.greedy;


/**
 * 670
 */
public class MaxSwap {

    public static int maximumSwap(int num) {

        // two pointers i<h && num[l]<num[h] &&  max(nums[h]) && Max(h-l)
        String numStr = String.valueOf(num);
        char[] nums = numStr.toCharArray();
        int l=0;
        Integer h=null;
        boolean findSwap=false;
        int maxLen = 0;
        for(int i=0;i<nums.length;i++){
            l=i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]>nums[l]){
                    findSwap = true;

                    if(h==null || (nums[j]>=nums[h] && j-i>maxLen )){
                        h=j;
                        maxLen = j-i;
                    }
                }
            }

            if(findSwap){
                break;
            }
        }

        if(findSwap){
            swap(nums,l,h);
        }

        return Integer.parseInt(new String(nums));
    }

    static void  swap(char[] nums,int l,int h){
        char tmp = nums[l];
        nums[l]=nums[h];
        nums[h]=tmp;
    }
}
