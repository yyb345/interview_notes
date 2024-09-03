package leetcode.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//TODO
public class LevelOrder {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        Queue<TreeNode> tmp=new LinkedList<>();
        if (root != null) {
            tmp.add(root);
            while(tmp.size()>0){
                List<Integer> dataList=new ArrayList<>();
                //每层有多少个节点
                int levelNum=tmp.size();
                for(int i=0;i<levelNum;i++){
                    TreeNode data = tmp.poll();
                    dataList.add(data.val);
                    if(data.left!=null){
                        tmp.add(data.left);
                    }
                    if(data.right!=null){
                        tmp.add(data.right);
                    }
                }
                result.add(dataList);
            }
        }

        return result;
    }
}
