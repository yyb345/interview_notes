package org.algorithm.binarytree.bst;

import org.algorithm.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 501
 */
public class FindModeBST {

    Integer preNum = null;
    int preLen = 1;
    int maxLen = 1;

    List<Integer> ret = new ArrayList<>();

    public int[] findMode(TreeNode root) {

        dfs(root);

        int[] nums = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            nums[i] = ret.get(i);
        }

        return nums;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        if (preNum == null) {
            ret.add(root.val);
        } else {
            if (preNum == root.val) {
                preLen++;
            } else {
                preLen = 1;
            }

            // update modes
            if (preLen == maxLen) {
                ret.add(root.val);
            } else if (preLen > maxLen) {
                ret = new ArrayList<>();
                ret.add(root.val);
                maxLen = preLen;
            }
        }
        preNum = root.val;

        dfs(root.right);
    }
}
