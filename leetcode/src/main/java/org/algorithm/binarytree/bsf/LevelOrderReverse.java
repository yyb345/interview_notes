package org.algorithm.binarytree.bsf;

import org.algorithm.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderReverse {

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
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }

            if(!reverse){
                list.add(levelList);
            }else {
                List<Integer> reverseList = new ArrayList<>();
                for(int i=levelList.size()-1;i>=0;i--){
                    reverseList.add(levelList.get(i));
                }
                list.add(reverseList);
            }

            reverse = !reverse;
        }

        return list;
    }
}
