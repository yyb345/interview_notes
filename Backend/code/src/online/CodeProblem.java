package online;


import java.util.*;

public class CodeProblem {


    public int peakIndexInMountainArray(int[] arr) {

        int l = 0;
        int h = arr.length-1;

        while(l<h){
            int mid = l +(h-l)/2;
            if(arr[mid]>arr[mid+1]){
                h=mid;
            }else if(arr[mid]<arr[mid+1]){
                l=mid+1;
            }
        }

        return l;
    }




    public static void main(String[] args) {

//        System.out.println(maximumSwap(2736));
//        System.out.println(maximumSwap(9973));
       int[][] nums = new int[][]{{2,1},{1,2}};

       Arrays.sort(nums,(a,b)-> a[0]-b[0]);

        for (int[] num : nums) {
            System.out.println(num[0]+","+num[1]);
        }

    }
}
