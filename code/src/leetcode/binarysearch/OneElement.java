package leetcode.binarysearch;

/**
 *  题目号： 540
 *  二分法的前台：1. 区间可以减半
 *  实现几个关键之处：
 *          1. while([a,b]) 开闭区间
 *          2. 区间砍半的逻辑
 *          3. 返回值是L还是H
 *  测试数据     一定要是 【0】 【1，2】【1，2，3】 至少三个这样的测试用例
 */
public class OneElement {

    // [0] [1,1,2] [1,2,2] [1,2,2,3,3] [1,1,2,2,3]
    // 0    2       0         0           4
    public static int findOne(int[] nums){

        int l =0;
        int h = nums.length-1;

        while(l<h){
            int mid = l + (h-l)/2;
            if(mid%2==0){
                if(mid+1<nums.length && nums[mid+1]!=nums[mid]){
                    h=mid;
                }else {
                    l=mid;
                }
            }else{
                if(mid-1>=0 && nums[mid-1]==nums[mid]){
                    l=mid+1;
                }else {
                    h=mid-1;
                }
            }
        }

        return nums[l];
    }

    public static void main(String[] args) {
        System.out.println(findOne(new int[]{3,3,7,7,10,11,11}));

    }
}
