package leetcode.binarytree;

import tool.TreeTool;

import java.util.ArrayList;
import java.util.List;

/**
 *  437  复习不是去记忆解法，而是为什么要这么做？，题目变形了怎么办？
 */
public class TreePathSum {

    int count =0;
    int targetSum;
    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum=targetSum;
        dfs(root,new ArrayList<>());

        return count;
    }

    void dfs(TreeNode root, List<Long> targetList){
        if(root==null){
            return ;
        }
        List<Long> subList = new ArrayList<>();
        if(targetSum==root.val){
            count++;
        }

        for(long target:targetList){
            if(root.val==target){
                count++;
            }
            subList.add(target-root.val);
        }
        subList.add(targetSum-(long)root.val);

        dfs(root.left,subList);
        dfs(root.right,subList);
    }

    public static void main(String[] args){


        int i = new TreePathSum().pathSum(
                TreeTool.buildTree(
                        new Integer[]{1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000}),
                8);
        System.out.println(i);

    }
}
