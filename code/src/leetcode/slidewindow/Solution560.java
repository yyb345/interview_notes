package leetcode.slidewindow;

public class Solution560 {

    public static int subarraySum(int[] nums, int k) {

        // 滑动窗口算法

        int l=0;
        int h=0;
        int count = 0;
        int widowSum = nums[0];
        while(l<=h && h<nums.length){
            if(widowSum<k){
                h++;
                widowSum= h<nums.length ? widowSum+nums[h]:0;
            }else {
                if(widowSum==k) count++;
                widowSum = widowSum-nums[l];
                l++;
            }
        }



        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1},2));
        System.out.println(subarraySum(new int[]{1,2,3},3));
        System.out.println(subarraySum(new int[]{1,1,1,1},8));
        System.out.println(subarraySum(new int[]{-1,-1,1},0));

    }
}
