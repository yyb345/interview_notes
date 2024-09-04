package leetcode.binarytree.travel;

import leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    // leecode 94
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        inorderAdd(root,ret);
        return ret;
    }


    public void inorderAdd(TreeNode root,List<Integer> list) {

        if(root==null){
            return;
        }
        inorderAdd(root.left,list);
        list.add(root.val);
        inorderAdd(root.right,list);
    }
}
