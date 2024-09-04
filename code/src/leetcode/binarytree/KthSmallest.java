package leetcode.binarytree;

import java.util.*;

//TODO 重写一下
public class KthSmallest {

    // leetcode 230
    public static int kthSmallest(TreeNode root, int k) {

        if(root==null || k==0){
            return -1;
        }
        int leftNum = nodeNum(root.left);

        if(leftNum+1==k){
            return root.val;
        }else if(k>(leftNum+1)){
            return kthSmallest(root.right,k-leftNum-1);
        }else {
            return kthSmallest(root.left,k);
        }

    }

    public  static  int nodeNum(TreeNode root){
        if(root==null){
            return 0;
        }
        return nodeNum(root.left)+nodeNum(root.right)+1;
    }
}
