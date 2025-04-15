package org.algorithm.binarytree.build;


import org.algorithm.binarytree.TreeNode;

/**
 * 108
 * 有序数组=> 二叉树
 *
 */
public class SortedArrayToBST {

    public  TreeNode sortedArrayToBST(int[] nums) {
        return build(nums,0,nums.length-1);
    }

    TreeNode build(int[] nums,int l,int h){
        if(l>h){
            return null;
        }

        int mid = l + (h-l)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums,l,mid-1);
        root.right= build(nums,mid+1,h);
        return root;
    }
}
