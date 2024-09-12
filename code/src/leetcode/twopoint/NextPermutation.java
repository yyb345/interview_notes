package leetcode.twopoint;

/**
 * 31
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {

        // right-->left find nums[right]>nums[left] then swap
        int h = nums.length-1;
        int t = h-1;
        boolean find = false;
        for(h=nums.length-1;h>=1;h--){
            if(nums[h]>nums[h-1]){
                find = true;
                break;
            }
        }

        int r = nums.length-1;
        int l = 0;
        if(find){
            // find minVal that greater than nums[h-1];
            int rr = h;
            int greaterIndex = h;
            int minVal = nums[h];
            while(rr<nums.length){
                if(nums[rr]>nums[h-1]){
                    if(nums[rr]<=minVal){
                        minVal = nums[rr];
                        greaterIndex = rr;
                    }
                }
                rr++;
            }
            // this is keypoit
            swap(nums,h-1,greaterIndex);
            l = h;
        }

        // swap all element
        while(l<r){
            swap(nums,r--,l++);
        }

    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
