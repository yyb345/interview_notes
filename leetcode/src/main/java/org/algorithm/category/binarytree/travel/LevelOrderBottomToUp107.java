package org.algorithm.category.binarytree.travel;


import org.algorithm.category.binarytree.TreeNode;
import org.algorithm.category.tool.TreeTool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 107
 * 输出从叶子节点到根节点每一层
 * 解题思路：DFS ： List<>  代表每层的数据
 * BFS也可以
 * 时间复杂度 O(N)
 * 空间复杂度 O(N)
 */
public class LevelOrderBottomToUp107 {

    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        dfs(root,0);
        Collections.reverse(ret);
        return ret;
    }

    void dfs(TreeNode root,int depth){
        if(root==null){
            return ;
        }
        if(ret.size()==depth){
            ret.add(new ArrayList<>(Arrays.asList(root.val)));
        }else {
            List<Integer> depthList = ret.get(depth);
            depthList.add(root.val);
        }
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);

    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeTool.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        List<List<Integer>> list = new LevelOrderBottomToUp107().levelOrderBottom(treeNode);
        System.out.println(list);
    }
}
