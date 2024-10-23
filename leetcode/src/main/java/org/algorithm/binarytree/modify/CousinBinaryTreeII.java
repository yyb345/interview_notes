package org.algorithm.binarytree.modify;

import org.algorithm.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2641
 */
public class CousinBinaryTreeII {

    List<Integer> sumList = new ArrayList<>();
    public TreeNode replaceValueInTree(TreeNode root) {


        dfs(root,0);
        modifyTree(root,0);
        root.val = 0;
        return root;
    }

    void dfs(TreeNode root,int depth){
        if(root==null){
            return;
        }
        if(sumList.size()==depth){
            sumList.add(root.val);
        }else{
            sumList.set(depth,sumList.get(depth)+root.val);
        }

        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }

    void modifyTree(TreeNode root, int depth){

        if(root==null){
            return;
        }

        int sum = (root.left!=null? root.left.val:0)+(root.right!=null? root.right.val:0);

        if(root.left!=null){
            root.left.val = sumList.get(depth+1)-sum;
            modifyTree(root.left,depth+1);
        }

        if(root.right!=null){
            root.right.val = sumList.get(depth+1)-sum;
            modifyTree(root.right,depth+1);
        }

    }
}
