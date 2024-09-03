package leetcode.binarytree;

import leetcode.Solution;
import treeproblem.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//TODO 重写一遍
public class IncreasingBST {

    // problem 897
    public TreeNode increasingBST(TreeNode root) {

        Stack<TreeNode> travel=new Stack<>();
        List<Integer> inOrder=new ArrayList<>();
        TreeNode p=root;
        while(travel.size()>0 || p!=null){
            if(p!=null){
                travel.push(p);
                p=p.left;
            }else{

                TreeNode preRoot=travel.pop();
                inOrder.add(preRoot.val);
                p=preRoot.right;
            }
        }

        TreeNode ans = new TreeNode(0), cur = ans;
        for (int v: inOrder) {
            cur.right = new TreeNode(v);
            cur = cur.right;
        }
        return ans.right;
    }
}
