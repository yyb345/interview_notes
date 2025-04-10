package org.algorithm.binarytree;

import org.algorithm.tool.TreeTool;

/**
 *  437  复习不是去记忆解法，而是为什么要这么做？，题目变形了怎么办？
 */
public class TreePathSumII {

    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode node, long sum) {
        if (node == null)
            return 0;
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }


    public static void main(String[] args){


        int i = new TreePathSumII().pathSum(
                TreeTool.buildTree(
                        new Integer[]{1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000}),
                8);
        System.out.println(i);

    }
}
