package org.algorithm.category.binarytree.bst;

import org.algorithm.category.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 95
 * 给定一个数字N，那么从1->N个元素,可以组成多少个二叉搜索树,把所有的树输出
 */
public class AllUniqueBSTBuild95 {

    public List<TreeNode> generateTrees(int n) {

        return dfs(1, n);
    }

    List<TreeNode> dfs(int start, int end) {

        List<TreeNode> ret = new ArrayList<>();
        if (start > end) {
            ret.add(null);
            return ret;
        }

        if (start == end) {
            TreeNode root = new TreeNode(start);
            return Arrays.asList(root);
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftChilds = dfs(start, i - 1);
            List<TreeNode> rightChilds = dfs(i + 1, end);

            for (TreeNode left : leftChilds) {
                for (TreeNode right : rightChilds) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ret.add(root);
                }
            }

        }

        return ret;
    }

    public static void main(String[] args){
        new AllUniqueBSTBuild95().generateTrees(2);
    }
}
