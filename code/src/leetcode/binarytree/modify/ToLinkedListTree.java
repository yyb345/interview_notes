package leetcode.binarytree.modify;

import leetcode.binarytree.TreeNode;

public class ToLinkedListTree {

    TreeNode pre=null,head=null;

    public TreeNode treeToDoubleList(TreeNode root) {

        if(root==null){
            return null;
        }
        dfs(root);
        pre.right = head;
        return head;
    }

    public void dfs(TreeNode root){

        if(root==null){
            return;
        }
        TreeNode cc = root;
        dfs(root.left);
        // 处理关系
        if(pre==null){
            head = root;
            pre=root;
        }else {
            pre.right = root;
            root.left = pre;
            pre=root;
        }
        dfs(root.right);
    }
}
