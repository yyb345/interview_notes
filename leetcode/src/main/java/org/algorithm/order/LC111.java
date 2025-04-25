package org.algorithm.order;

import org.algorithm.category.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111
 * 二叉树最小深度
 * 时间复杂度 O(N) 空间复杂度O(N)
 */
public class LC111 {

    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int depth=0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            depth++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left==null && node.right==null){
                    return depth;
                }
                if(node.left!=null){ queue.add(node.left);}
                if(node.right!=null){ queue.add(node.right);}
            }
        }
        return -1;
    }
}
