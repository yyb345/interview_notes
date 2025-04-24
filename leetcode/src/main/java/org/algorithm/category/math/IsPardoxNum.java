package org.algorithm.category.math;

/**
 * 9
 * Given an integer x, return true if x is a palindrome and false otherwise.
 */
public class IsPardoxNum {

    public static boolean isPalindrome(int x) {

        if(x<0){
            return false;
        }
        int oldx = x;
        int newx = 0;
        while(x>0){
            newx = newx*10 + x%10;
            x = x/10;
        }

        return oldx==newx;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
