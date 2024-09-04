package leetcode.binarytree.bst;

import leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

//TODO 一定要重写
public class LowestCommonAncestor {

    // leetcode 236

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null || p==null || q==null ){
            return null;
        }


        TreeNode ret = null;

        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();
        findNodePath(root, p.val,new ArrayList<>(),pPath);
        findNodePath(root, q.val,new ArrayList<>(),qPath);

        int index =0 ;
        while(index<Math.min(pPath.size(),qPath.size())){
            TreeNode pNode = pPath.get(index);
            TreeNode qNode = qPath.get(index);
            if(pNode.val ==qNode.val){
                ret = pNode;
            }else {
                break;
            }
            index++;
        }

        return ret;
    }



    public boolean findNodePath(TreeNode root,int target,List<TreeNode> list,List<TreeNode> ret){

        if(root==null){
            return false;
        }

        list.add(root);
        if(root.val==target){
            ret.addAll(new ArrayList<>(list));
            return true;
        }
        if(root.left!=null){
            if(findNodePath(root.left,target,list,ret)){
                return true;
            }
        }

        if(root.right!=null){
            if(findNodePath(root.right,target,list,ret)){
                return true;
            }
        }
        list.remove(root);

        return false;
    }
}
