package org.algorithm.category.array;

/**
 * 27
 */
public class RemoveELement {

    public int removeElement(int[] nums, int val) {


        int l=0;
        int h = nums.length-1;

        while(l<=h){

            while(l<nums.length && nums[l]!=val){
                l++;
            }

            while(h>=0 && nums[h]==val){
                h--;
            }

            if(l>h){
                break;
            }

            nums[l]=nums[h];
            l++;
            h--;

        }

        return h+1;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveELement().removeElement(new int[]{3,2,2,3},3));
        System.out.println(new RemoveELement().removeElement(new int[]{0,1,2,2,3,0,4,2},2));
    }
}

