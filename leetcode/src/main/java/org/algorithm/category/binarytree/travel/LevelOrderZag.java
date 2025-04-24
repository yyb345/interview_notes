package org.algorithm.category.binarytree.travel;

import org.algorithm.category.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103
 * ZAG遍历
 * 时间复杂度 O(n)
 * 空间复杂度 O(K+n) K=level number
 */
public class LevelOrderZag {

    public List<List<Integer>> levelOrderReverse(TreeNode root) {
        if(root==null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> list = new ArrayList<>();
        boolean reverse = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode currentNode = queue.poll();
                levelList.add(currentNode.val);
                if(currentNode.left!=null){queue.add(currentNode.left);}
                if(currentNode.right!=null){queue.add(currentNode.right);
                }
                if(reverse){
                    levelList.add(currentNode.val);
                }else{
                    levelList.add(0,currentNode.val);
                }
            }
            list.add(levelList);
            reverse = !reverse;
        }
        return list;
    }
}
