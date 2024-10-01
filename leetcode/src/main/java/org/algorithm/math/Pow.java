package org.algorithm.math;

/**
 * 50
 * Pow(x,n)
 */
public class Pow {

    public double myPow(double x, int n) {

        if(n<0){
            // 关键在这儿 -2147483648，会有问题
            return 1/(x*myPow(x,Math.abs(n+1)));
        }

        if(n==0){
            return 1.0d;
        }

        int sub = n/2;

        if(n%2==0){
            double subpow = myPow(x,n/2);
            return subpow*subpow;
        }else {
            double subpow = myPow(x,n/2);
            return subpow*subpow*x;
        }

    }

    public static void main(String[] args) {
        new Pow().myPow(2.00,-2147483648);
    }
}
