package org.algorithm.binarysearch;

import java.util.Arrays;

/**
 * 3281
 * 最小差值的最大值
 */
public class MaxPossibleScore {

    public int maxPossibleScore(int[] start, int d) {

        if(start==null ||start.length==0 ){
            return 0;
        }

        Arrays.sort(start);


        int ret = 0;
        long l = 0;
        long h = Long.MAX_VALUE;
        while(l<=h){
            long mid = l + (h-l)/2;
            if(check(start,mid,d)){
                ret=(int)mid;
                l=mid+1;
            }else{
                h=mid-1;
            }
        }

        return ret;
    }

    boolean check(int[] start,long v,int d){

        long left = start[0];
        for(int i=1;i<start.length;i++){

            if(left+v > start[i]+d){
                return false;
            }else{
                left = Math.max(left+v,start[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new MaxPossibleScore().maxPossibleScore(new int[]{0,9,2,9},2));
        System.out.println(new MaxPossibleScore().maxPossibleScore(new int[]{6,0,3},2));
        System.out.println(new MaxPossibleScore().maxPossibleScore(new int[]{2,6,13,13},5));
        System.out.println(new MaxPossibleScore().maxPossibleScore(new int[]{999968519,999974432},999958114));

        System.out.println(999958114+999958114);
    }
}
