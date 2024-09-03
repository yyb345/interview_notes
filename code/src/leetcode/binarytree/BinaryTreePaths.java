package leetcode.binarytree;

import leetcode.Solution;
import treeproblem.TreeNode;

import java.util.ArrayList;
import java.util.List;

//TODO 重写一遍
public class BinaryTreePaths {

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new ArrayList();

        if(root==null)
            return result;

        if(root.left!=null){
            List<String> strings = binaryTreePaths(root.left);
            result.addAll(strings);
        }
        if(root.right!=null){
            List<String> strings = binaryTreePaths(root.right);
            result.addAll(strings);
        }

        if(root.left==null && root.right==null){
            result.add(""+root.val);

        } else{
            for(int j=0;j<result.size();j++){
                String s = root.val+"->"+result.get(j);
                result.set(j,s);
            }
        }

        return result;
    }
}
