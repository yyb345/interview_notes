package org.algorithm.category.binarytree.build;

import org.algorithm.category.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1382
 */
public class BalanceBST {

    List<Integer> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {

        inorder(root);

        return build(0,list.size()-1);
    }

    void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    TreeNode build(int l,int h){
        if(l>h){
            return null;
        }

        int mid = l +(h-l)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left=build(l,mid-1);
        root.right=build(mid+1,h);

        return root;
    }
}
