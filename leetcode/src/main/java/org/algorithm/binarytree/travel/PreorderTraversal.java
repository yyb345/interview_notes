package org.algorithm.binarytree.travel;

import org.algorithm.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144
 * 前序遍历
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
