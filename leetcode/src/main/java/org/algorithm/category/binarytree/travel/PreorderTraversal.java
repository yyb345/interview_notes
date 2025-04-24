package org.algorithm.category.binarytree.travel;

import org.algorithm.category.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144
 * 前序遍历
 * 时间复杂度 O(n)
 * 空间复杂度 O(n)
 */
public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        travel(root,ret);
        return ret;
    }

    void travel(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        list.add(root.val);
        travel(root.left,list);
        travel(root.right,list);
    }
}
