package org.algorithm.category.array;

//TODO
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {

        k=nums.length-k;
        int l=0,h=nums.length-1;

        while(true){
            int index=partition(nums,l,h);
            if(index<k)
                l=index+1;
            else if(index>k)
                h=index-1;
            else if(index==k)
                break;
        }

        return nums[k];

    }

    public int partition(int[] nums,int l,int h){

        int i=l,j=h+1;

        while(i<j){
            while(nums[++i]<nums[l] && i<h);
            while(nums[--j]>nums[l] && j>l);
            swap(nums,i,j);
        }
        swap(nums,l,j);
        return j;
    }

    public void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
