package leetcode.binarytree.build;


import leetcode.binarytree.TreeNode;

public class SortedArrayToBST {

    public static TreeNode sortedArrayToBST(int[] nums) {
        int middleIndex = (nums.length - 1) / 2;

        if (middleIndex > 0) {
            int[] left = new int[middleIndex];
            int[] right = new int[nums.length - middleIndex - 1];
            for (int i = 0; i < middleIndex; i++) {
                left[i] = nums[i];
            }
            for (int i = middleIndex + 1; i < nums.length; i++) {
                right[i] = nums[i];
            }
            TreeNode result = new TreeNode(nums[middleIndex]);
            result.left = sortedArrayToBST(left);
            result.right = sortedArrayToBST(right);
            return result;

        } else {
            TreeNode result = new TreeNode(nums[middleIndex]);
            return result;
        }


    }
}
