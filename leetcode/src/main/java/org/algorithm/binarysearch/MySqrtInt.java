package org.algorithm.binarysearch;

public class MySqrtInt {

    public static int mySqrt(int x) {
        long l = 0;
        long h = x;
        long r = l;
        while(l<h){
            long mid = l + (h-l)/2;
            if(mid*mid==x){
                return (int) mid;
            }else if(mid*mid<x){
                r = mid;
                l = mid+1;
            }else {
                h = mid-1;
            }
        }

        return (int) r;
    }
}
