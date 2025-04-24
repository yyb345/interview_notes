package org.algorithm.category.bit;

/**
 * 191
 *
 */
public class Num1Bit {

    public int hammingWeight(int n) {

        int count=0;
        while(n>0){
            int xx= n&1 ;// 相当于 n%2;
            if(xx==1){
                count++;
            }
            n=n>>1;// 相当于 n/2;
        }

        return count;
    }
}
