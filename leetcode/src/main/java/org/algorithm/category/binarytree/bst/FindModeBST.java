package org.algorithm.category.binarytree.bst;

import org.algorithm.category.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 501
 * 找出重复值最多的一堆数字
 */
public class FindModeBST {

    Integer preNum = null;
    int preLen = 1;
    int maxLen = 1;

    List<Integer> ret = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        return ret.stream().mapToInt(Integer::intValue).toArray();
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
                ret.clear();
                ret.add(root.val);
                maxLen = preLen;
            }
        }
        preNum = root.val;

        dfs(root.right);
    }
}
