package org.algorithm.order;

import org.algorithm.category.binarytree.TreeNode;

/**
 * 99
 * 二叉搜索树中有两个元素错误的被交换，请恢复
 * 想象成一个单调递增的数组，有两个数字交换，那么第一个非法的是前>后 第二个是后<前
 * 时间复杂度 O(N) 空间复杂度O(1)
 */
public class LC99 {

    TreeNode node1,node2 = null;
    TreeNode preNode = null;
    public void recoverTree(TreeNode root) {
        dfs(root);
        // 交换节点
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }

    void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.left);
        if(preNode!=null){
            if(preNode.val > root.val){
                if(node1==null){
                    node1 = preNode;
                }
                node2 = root;
            }
        }
        preNode = root;
        dfs(root.right);
    }
}
