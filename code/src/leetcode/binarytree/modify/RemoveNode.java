package leetcode.binarytree.modify;

import leetcode.binarytree.TreeNode;

/**
 * 450
 * Delete Node in a BST
 */
public class RemoveNode {

    public TreeNode deleteNode(TreeNode root, int key) {

        if(root==null){
            return null;
        }

        if(root.val>key){
            root.left = deleteNode(root.left,key);
        }else if(root.val<key){
            root.right = deleteNode(root.right,key);
        }else {
            // find root.right --->left
            TreeNode right = root.right;
            if(right!=null){
                while(right!=null && right.left!=null){
                    right = right.left;
                }
                root.val = right.val;
                root.right = deleteNode(root.right,right.val);
            }else {
                root = root.left;
            }
        }

        return root;
    }

}
