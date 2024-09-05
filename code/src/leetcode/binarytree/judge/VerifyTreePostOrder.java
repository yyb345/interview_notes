package leetcode.binarytree.judge;

//TODO 优化一版
public class VerifyTreePostOrder {

    public boolean verifyTreeOrder(int[] postorder) {

        // 1. 定义 root postorder[end]
        // 2. 然后从start->end 开始，小于<root的区间[start,index]为left [index+1,end-1] 是right
        // 3. 终止条件如何定义

        return verify(postorder,0,postorder.length-1,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    boolean verify(int[] nums,int start,int end, int minVal, int maxVal){

        // 终止
        if(start<0 || start>end){
            return true;
        }
        // 1. 区间数据是否满足要求
        for(int i=start;i<=end;i++){
            if(nums[i]<minVal){
                return false;
            }
            if(nums[i]>maxVal){
                return false;
            }
        }

        //2. split
        Integer index = start;
        for(int i=start;i<end;i++){
            if(nums[i]>nums[end]){
                index=i;
                break;
            }
        }

        return verify(nums,start,index-1,minVal,nums[end]) &&
                verify(nums, index, end-1, nums[end], maxVal);
    }
}
