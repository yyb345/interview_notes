package leetcode.binarytree.search;

import leetcode.binarytree.TreeNode;

import java.util.*;

//TODO 优化一版
public class FindDistanceK {

    Map<TreeNode, TreeNode> parents=new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        List<Integer> result=new ArrayList<>();

        dfs(root,null);

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(null);
        queue.add(target);

        Set<TreeNode> traveled=new HashSet<>();
        traveled.add(target);
        traveled.add(null);

        int distance=0;

        while(queue.size()>0){
            TreeNode poll = queue.poll();
            if(poll==null){

                if(distance==K){
                    break;
                }

                queue.add(null);
                distance++;

            }else {
                if(!traveled.contains(poll.left)){
                    traveled.add(poll.left);
                    queue.add(poll.left);
                }

                if(!traveled.contains(poll.right)){
                    traveled.add(poll.right);
                    queue.add(poll.right);
                }

                TreeNode pollParent = parents.get(poll);
                if(!traveled.contains(pollParent)){
                    traveled.add(pollParent);
                    queue.add(pollParent);
                }


            }
        }


        for(TreeNode t:queue){
            result.add(t.val);
        }

        return  result;


    }


    public void dfs(TreeNode node, TreeNode parent){
        if(node!=null){
            parents.put(node,parent);
            dfs(node.left,node);
            dfs(node.right,node);
        }
    }
}
