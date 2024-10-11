package org.algorithm.binarytree.build;

import org.algorithm.binarytree.TreeNode;

/**
 * 654
 * 最大的值为根，左边为左子树、右边为又子树
 * Input: nums = [3,2,1,6,0,5]
 * Output: [6,3,5,null,2,0,null,null,1]
 */
public class MaxBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return build(nums,0,nums.length-1);
    }

    TreeNode build(int[] nums,int l,int h){
        if(l>h){
            return null;
        }
        int index = findRootIndex(nums,l,h);
        TreeNode root = new TreeNode(nums[index]);

        root.left = build(nums,l,index-1);
        root.right = build(nums,index+1,h);

        return root;
    }

    int findRootIndex(int[] nums,int l,int h){
        int ret = l;
        int max = nums[l];
        for(int i=l+1;i<=h;i++){
            if(nums[i]>max){
                max = nums[i];
                ret=i;
            }
        }

        return ret;
    }
}
