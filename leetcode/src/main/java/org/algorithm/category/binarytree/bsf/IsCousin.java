package org.algorithm.category.binarytree.bsf;

import org.algorithm.category.binarytree.TreeNode;
import org.algorithm.category.tool.TreeTool;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题号：993
 * https://leetcode.com/problems/cousins-in-binary-tree/description/
 * 这道题目的核心是 BFS，BFS的特点是找到后就不会往下遍历了。
 */
public class IsCousin {


    TreeNode xParent,yParent;

    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    if(node.left.val==x || node.left.val==y){
                        if(node.left.val==x){
                            xParent=node;
                        }else if(node.left.val==y){
                            yParent=node;
                        }
                    }
                    queue.add(node.left);
                }

                if(node.right!=null){
                    if(node.right.val==x || node.right.val==y){
                        if(node.right.val==x){
                            xParent=node;
                        }else if(node.right.val==y){
                            yParent=node;
                        }
                    }
                    queue.add(node.right);
                }

            }

            if(xParent!=null || yParent!=null){
                if(xParent!=null && yParent!=null && xParent!=yParent){
                    return true;
                }
                return false;
            }
        }

        return false;
    }



    public static void main(String[] args) {

        System.out.println(new IsCousin().isCousins( TreeTool.buildTree(new Integer[]{1, 2, 3, 4}), 4, 3));
        System.out.println(new IsCousin().isCousins( TreeTool.buildTree(new Integer[]{1,2,3,null,4,null,5}), 5, 4));
        System.out.println(new IsCousin().isCousins( TreeTool.buildTree(new Integer[]{1, 2, 3, null, 4}), 2, 3));

    }
}
