package org.algorithm.binarytree.bsf;

import org.algorithm.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515
 * 每行最大的值
 */
public class LargestValues {
    List<Integer> ret = new ArrayList<>();
    public  List<Integer> largestValues(TreeNode root) {

        dfs(root,0);
        return ret;
    }

    void dfs(TreeNode root,int depth){
        if(root==null){
            return;
        }
        if(ret.size()==depth){
            ret.add(root.val);
        }else {
            ret.set(depth,Math.max(ret.get(depth),root.val));
        }
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
}
