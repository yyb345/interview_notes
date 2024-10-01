package org.algorithm.binarytree.modify;

import org.algorithm.binarytree.TreeNode;

/**
 * 1038
 * 二叉搜索树值变更
 */
public class BstToGst {
    int sum=0;
    public TreeNode bstToGst(TreeNode root) {

        if(root==null){
            return null;
        }

        bstToGst(root.right);

        root.val += sum;
        sum = root.val;

        bstToGst(root.left);

        return root;
    }
}
