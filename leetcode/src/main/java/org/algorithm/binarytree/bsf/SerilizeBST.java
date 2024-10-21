package org.algorithm.binarytree.bsf;

import org.algorithm.binarytree.TreeNode;

/**
 * 449
 */
public class SerilizeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root==null){
            return "";
        }


        StringBuilder sb =  new StringBuilder();
        sb.append(root.val);

        if(root.left==null && root.right==null){
            return sb.toString();
        }

        if(root.left!=null){
            String left = serialize(root.left);
            sb.append(",");
            sb.append(left);
        }

        if(root.right!=null){
            String right = serialize(root.right);
            sb.append(",");
            sb.append(right);
        }

        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.length()==0){
            return null;
        }
        String[] array= data.split(",");
        int[] nums = new int[array.length];
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.parseInt(array[i]);
        }

        return build(nums,0,nums.length-1);
    }

    TreeNode build(int[] arr,int l,int h){

        if(l>h){
            return null;
        }

        int rootValue = arr[l];
        TreeNode root = new TreeNode(rootValue);

        int[] lr = findLeftRight(arr,rootValue,l,h);
        root.left= build(arr,l+1,lr[0]);
        root.right= build(arr,lr[1],h);

        return root;
    }

    int[] findLeftRight(int[] nums,int root,int l,int h){
        int[] ret = new int[]{-1,h+1};
        for(int i=l+1;i<=h;i++){
            if(nums[i]<root){
                ret[0] = i;
            }else {
                ret[1] = i;
                break;
            }
        }

        return ret;
    }
}
