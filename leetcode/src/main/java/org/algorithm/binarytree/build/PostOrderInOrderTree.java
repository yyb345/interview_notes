package org.algorithm.binarytree.build;

import org.algorithm.binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106
 * 根据中序和后序遍历结果，构建二叉树
 */
public class PostOrderInOrderTree {

    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        initMap(inorder);
        return build(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }

    TreeNode build(int[] inorder, int[] postorder,int il,int ih,int pl,int ph){
        if(il>ih ){
            return null;
        }
        TreeNode root = new TreeNode(postorder[ph]);
        int rootIndex = map.get(postorder[ph]);
        int left = rootIndex-il;

        TreeNode leftNode = build(inorder,postorder,il,rootIndex-1,pl,pl+left-1);
        TreeNode rightNode = build(inorder,postorder,rootIndex+1,ih,pl+left,ph-1);
        root.left= leftNode;
        root.right=rightNode;

        return root;
    }

    void initMap(int[] nums){
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
    }


    // int findRootIndex(int[] nums,int target,int l ,int h){

    //     for(int i=l;i<=h;i++){
    //         if(nums[i]==target){
    //             return i;
    //         }
    //     }

    //     return -1;
    // }
}
