package leetcode.binarytree.modify;

import leetcode.binarytree.TreeNode;
import tool.TreeTool;

/**
 * 1325
 * 后序遍历
 */
public class RemoveLeafNodes {

    public TreeNode removeLeafNodes(TreeNode root, int target) {

        if(root==null){
            return null;
        }
        if(root.left!=null){
            root.left = removeLeafNodes(root.left,target);
        }

        if(root.right!=null){
            root.right=removeLeafNodes(root.right,target);
        }

        if(root.left==null && root.right==null && root.val == target){
            return null;
        }

        return root;
    }

    public static void main(String[] args) {

        TreeNode treeNode = new RemoveLeafNodes().removeLeafNodes(TreeTool.buildTree(new Integer[]{1, 1, 1}), 1);
        System.out.println(treeNode.val);
    }
}
