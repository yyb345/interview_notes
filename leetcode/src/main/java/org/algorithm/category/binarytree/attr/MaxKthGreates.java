package org.algorithm.category.binarytree.attr;


import org.algorithm.category.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2583
 */
public class MaxKthGreates {

    List<Long> list = new ArrayList<>();
    public long kthLargestLevelSum(TreeNode root, int k) {

        dfs(root,0);

        if(list.size()<k){
            return -1;
        }

        Collections.sort(list);

        return list.get(list.size()-k);
    }

    void dfs(TreeNode root,int depth){
        if(root==null){
            return;
        }
        if(list.size()==depth){
            list.add((long)root.val);
        }else{
            list.set(depth,list.get(depth)+root.val);
        }

        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
}
