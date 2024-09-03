package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//TODO 重写一遍
public class InorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {

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
