package leetcode.binarytree.attr;

import leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 199 二叉树右视图
 * root->right->left
 * if(exist) add;
 */
public class RightSideView {

    List<Integer> ret = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {

        dfs(root,ret,0);
        return ret;
    }

    void dfs(TreeNode root, List<Integer> list, int depth){
        if(root==null){
            return;
        }

        if(list.size()==depth){
            list.add(root.val);
        }

        dfs(root.right,list,depth+1);
        dfs(root.left,list,depth+1);
    }
}
