package org.algorithm.binarytree.search;

import org.algorithm.binarytree.TreeNode;

import java.util.*;

/**
 * 863
 */
public class FindDistanceK {


    int _k;
    List<Integer> ret = new ArrayList<>();

    Map<TreeNode, Boolean> visited = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this._k = k;
        dfs(root, target);
        return ret;
    }

    int dfs(TreeNode root, TreeNode target) {
        if (root == null) {
            return -1;
        }
        if (root == target) {
            findAndAddKNode(root, _k);
            return 0;
        }
        int left = dfs(root.left, target);
        int right = dfs(root.right, target);

        int distance = left != -1 ? left + 1 : right != -1 ? right + 1 : -1;

        if (distance != -1) {
            findAndAddKNode(root, _k  - distance);
        }
        return distance;
    }

    void findAndAddKNode(TreeNode root, int k) {
        if (root == null || k < 0) {
            return;
        }
        if (visited.getOrDefault(root, false)) {
            return;
        }
        visited.put(root, true);
        if (k == 0) {
            ret.add(root.val);
        }
        findAndAddKNode(root.left, k - 1);
        findAndAddKNode(root.right, k - 1);
    }

    public static void main(String[] args) {

    }


}
