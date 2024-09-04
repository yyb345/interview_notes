package leetcode.binarytree.bst;

import leetcode.binarytree.TreeNode;

public class LowestCommonAncestorBST {

    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null || p==null || q==null){
            return null;
        }
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val,q.val);
        if(root.val < min){
            return lowestCommonAncestorBST(root.right,p,q);
        }else if(root.val> max){
            return lowestCommonAncestorBST(root.left,p,q);
        }else if(root.val== p.val){
            return p;
        }else if(root.val==q.val){
            return q;
        }else if(root.val>min && root.val<max){
            return root;
        }

        return null;
    }
}
