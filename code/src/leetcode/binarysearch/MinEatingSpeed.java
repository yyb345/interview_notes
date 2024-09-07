package leetcode.binarysearch;

import java.util.Arrays;

public class MinEatingSpeed {

    public int minEatingSpeed(int[] piles, int H) {

        int l=0;
        int h = Arrays.stream(piles).max().getAsInt();

        while(l<h){
            int mid = (l + (h-l)/2);
            int num = check(piles, mid);
            if(num>H){
                l = mid +1;
            }else if(num<=H) {
                h = mid;
            }
        }

        return h;
    }

    int check(int[] nums,int k){
        int num = 0;
        for(int i=0;i<nums.length;i++){
            num+=findUp(nums[i],k);
        }
        return num;
    }

    int findUp(int n,int m){
       if(n%m==0){
           return n/m;
       }else {
           return n/m+1;
       }
    }

    public static void main(String[] args) {

        System.out.println(new MinEatingSpeed().minEatingSpeed(new int[]{3,6,7,11},8));
        System.out.println(new MinEatingSpeed().minEatingSpeed(new int[]{30,11,23,4,20},5));
        System.out.println(new MinEatingSpeed().minEatingSpeed(new int[]{30,11,23,4,20},6));

    }


}
