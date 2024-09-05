package leetcode.binarytree.travel;

import leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94
 * 中序遍历
 */
public class InorderTraversal {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        inorderAdd(root,ret);
        return ret;
    }


    public void inorderAdd(TreeNode root,List<Integer> list) {

        if(root==null){
            return;
        }
        inorderAdd(root.left,list);
        list.add(root.val);
        inorderAdd(root.right,list);
    }


    // 不使用递归，采用迭代
    public static List<Integer> inorderTraversalIter(TreeNode root) {

        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> container=new Stack<>();
        TreeNode iter=root;

        while(container.size()>0 || iter!=null){

            if(iter!=null){
                container.push(iter);
                iter=iter.left;
            }else{
                TreeNode treeNode=container.pop();
                result.add(treeNode.val);
                iter=treeNode.right;
            }
        }

        return result;

    }
}
