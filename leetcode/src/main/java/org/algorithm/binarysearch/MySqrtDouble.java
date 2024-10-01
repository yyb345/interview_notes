package org.algorithm.binarysearch;

/**
 *
 */
//TODO 优化一版
public class MySqrtDouble {

    public int mySqrt(int x) {
        if(x<=1){
            return x;
        }
        double low = 0;
        double high = x;
        double jingdu =0.00001;
        while(low<high){
            double mid = (low+high)/2;
            if((x-mid*mid)>jingdu){
                low = mid;
            }else if((mid*mid-x)>jingdu){
                high = mid;
            }else  {
                System.out.println(mid);
                return (int)mid;
            }
        }

        return 0;
    }
}
