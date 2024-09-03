package leetcode.binarytree;

import leetcode.Solution;
import treeproblem.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValue {

    public static int  findBottomLeftValue(TreeNode root) {

        int result=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(queue.size()>0){
            int levelSize = queue.size();
            for(int i=0;i<levelSize;i++){
                TreeNode pop = queue.poll();
                if(i==0){
                    result=pop.val;
                }
                if(pop.left!=null){
                    queue.add(pop.left);
                }
                if(pop.right!=null){
                    queue.add(pop.right);
                }
            }
        }

        return result;
    }
}
