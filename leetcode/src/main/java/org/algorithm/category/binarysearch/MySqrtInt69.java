package org.algorithm.category.binarysearch;

/**
 * leetcode 69
 * 时间复杂度 O(Log(N)) 空间复杂度 O(1)
 */
public class MySqrtInt69 {

    public static int mySqrt(int x) {
        long l = 0;
        long h = x;
        long result = l;
        while(l<h){
            long mid = l + (h-l)/2;
            if(mid*mid==x){
                return (int) mid;
            }else if(mid*mid<x){
                result = mid;
                l = mid+1;
            }else {
                h = mid-1;
            }
        }

        return (int) result;
    }
}
