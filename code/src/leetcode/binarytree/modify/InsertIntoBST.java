package leetcode.binarytree.modify;

import leetcode.binarytree.TreeNode;

/**
 * 701
 * 二叉搜索树插入一个节点
 */
public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root==null){
            return new TreeNode(val);
        }

        if(root.val>val){
            root.left =  insertIntoBST(root.left,val);
        }else {
            root.right = insertIntoBST(root.right,val);
        }

        return root;
    }
}
