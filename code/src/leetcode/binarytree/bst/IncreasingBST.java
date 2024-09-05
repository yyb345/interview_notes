package leetcode.binarytree.bst;

import leetcode.binarytree.TreeNode;
import tool.TreeTool;



/** 897
 * Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.
 *
 * Example 1:
 *
 * Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 * 注意最后一个节点的处理
 */
public class IncreasingBST {

    TreeNode preNode = null;
    TreeNode ret = null;

    public TreeNode increasingBST(TreeNode root) {

        if(root==null){
            return null;
        }

        dfs(root);
        preNode.right=null;
        preNode.left=null;

        return ret;
    }

    void dfs(TreeNode root){
        if(root==null){
            return;
        }

        dfs(root.left);
        if(preNode==null){
            ret = root;
        }else {
            preNode.left=null;
            preNode.right=root;
        }
        preNode = root;

        dfs(root.right);
    }




    public static void main(String[] args) {
        TreeNode treeNode = TreeTool.buildTree(new Integer[]{2,1,4,null,null,3});

        TreeNode afterNode = new IncreasingBST().increasingBST(treeNode);
        TreeTool.printTree(afterNode);
    }

}
