package leetcode.binarytree.bst;

import leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

//TODO 重写一遍
public class KthLargestBST {

    public int kthLargest(TreeNode root, int k) {

        if(root==null){
            return -1;
        }


        List<Integer> allData = new ArrayList<>();
        middleTravel(root,allData);

        int size = allData.size();
        if(k>size){
            return -1;
        }

        return allData.get(size-k);

    }

    void middleTravel(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        middleTravel(root.left,list);
        list.add(root.val);
        middleTravel(root.right,list);
    }
}
