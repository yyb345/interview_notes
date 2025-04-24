package org.algorithm.category.binarytree.build;

import org.algorithm.category.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 894, 相比较之前，有了map存储之前保存的结果，可以把时间复杂度变低。
 * 笔记：这种后序遍历的，需要将左右节点合并的，且左右具有相同功能的，要注意存储缓存。
 *
 */
public class AllPossibleFBT {

    Map<Integer,List<TreeNode>> map = new HashMap<>();
    public  List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> result = new ArrayList();

        if(map.containsKey(N)){
            return map.get(N);
        }

        if (N == 1) {
            TreeNode tmp = new TreeNode(0);
            result.add(tmp);
        } else {
            int subTotal = N - 1;
            int left = 1;
            while (left < subTotal) {
                List<TreeNode> leftTreeNodes = allPossibleFBT(left);
                List<TreeNode> rightTreeNodes = allPossibleFBT(subTotal - left);
                for (TreeNode l : leftTreeNodes) {
                    for (TreeNode r : rightTreeNodes) {
                        TreeNode tmp = new TreeNode(0);
                        tmp.left = l;
                        tmp.right = r;
                        result.add(tmp);
                    }
                }
                left = left+2;
            }
        }
        map.put(N,result);
        return result;
    }
}
