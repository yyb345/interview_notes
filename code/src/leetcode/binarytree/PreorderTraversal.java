package leetcode.binarytree;

import leetcode.Solution;
import treeproblem.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//TODO 重写一遍
public class PreorderTraversal {

    // problem 144
    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        Stack<String> status=new Stack<>();
        Stack<Boolean> finish=new Stack<>();
        stack.push(root);
        status.push("L");
        finish.push(false);

        result.add(root.val);


        while(stack.size()>0 ){


            TreeNode current=stack.peek();
            String currentStatus=status.peek();

            if(currentStatus.equals("L")){
                if(current.left!=null){
                    stack.push(current.left);
                    status.push("L");
                    result.add(current.left.val);
                    finish.push(false);
                }else{

                    status.pop();
                    status.push("R");

                }
            }else if(currentStatus.equals("R")){
                if(current.right!=null){
                    stack.push(current.right);
                    status.push("L");
                    result.add(current.right.val);
                    finish.push(false);
                }else{
                    status.pop();
                    stack.pop();
                    //右边已结束
                    status.pop();
                    status.push("R");
                    finish.pop();
                    finish.push(true);
                }
                if(stack.size()==1 && finish.peek()){
                    stack.pop();
                }
            }
        }
        return result;
    }
}
