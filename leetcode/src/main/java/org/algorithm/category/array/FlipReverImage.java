package org.algorithm.category.array;

public class FlipReverImage {

    public int[][] flipAndInvertImage(int[][] image) {

        for(int i=0;i<image.length;i++){

            int l=0;
            int h = image[i].length-1;

            while(l<=h){
                swap(image[i],l,h);
                invert(image[i],l);
                invert(image[i],h);
                l++;
                h--;
            }
        }

        return image;
    }

    void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    void invert(int[] nums,int i){
        if(nums[i]==1){
            nums[i]=0;
        }else if(nums[i]==0){
            nums[i]=1;
        }
    }

    public static void main(String[] args) {
        new FlipReverImage().flipAndInvertImage(new int[][]{{1,1,0},{1,0,1},{0,0,0}});
    }
}
