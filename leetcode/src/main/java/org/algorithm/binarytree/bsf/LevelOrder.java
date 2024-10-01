package org.algorithm.binarytree.bsf;

import org.algorithm.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LevelOrder {

    public static List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> dataList=new ArrayList<>();
            //每层有多少个节点
            int levelNum=queue.size();
            for(int i=0;i<levelNum;i++){
                TreeNode data = queue.poll();
                dataList.add(data.val);
                if(data.left!=null){
                    queue.add(data.left);
                }
                if(data.right!=null){
                    queue.add(data.right);
                }
            }
            result.add(dataList);
        }

        return result;
    }
}
