package org.algorithm.category.binarytree.attr;

import org.algorithm.category.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 515
 * 每行最大的值
 * 记录每一层List<>的数据
 * 时间复杂度 O(N) 空间复杂度 O(LogN)
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
