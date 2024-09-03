package treeproblem;

import java.util.ArrayList;
import java.util.List;

public class AllSearchTree {

    public List<TreeNode> generateTrees(int n) {

        boolean[] visited = new boolean[n+1];
        return generate(n,visited,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    List<TreeNode> generate(int n, boolean[] visited, int minVal, int maxVal) {

        for (int i = 1; i <= n; i++) {
            if (visited[i] || i <= minVal || i >= maxVal) {
                continue;
            }

            visited[i] = true;

            List<TreeNode> leftList = generate(n, visited, minVal, i);
            List<TreeNode> rightList = generate(n, visited, i, maxVal);
            visited[i] = false;

            List<TreeNode> ret = new ArrayList<>();


            if(leftList.isEmpty() && rightList.isEmpty()){
                ret.add(new TreeNode(i));
            }else if(!leftList.isEmpty() && rightList.isEmpty()){
                for (TreeNode left : leftList) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    ret.add(node);
                }
            }else if(leftList.isEmpty() && !rightList.isEmpty()){
                for (TreeNode right : rightList) {
                    TreeNode node = new TreeNode(i);
                    node.right = right;
                    ret.add(node);
                }
            }else {
                for (TreeNode left : leftList) {
                    for (TreeNode right : rightList) {
                        TreeNode node = new TreeNode(i);
                        node.left = left;
                        node.right = right;
                        ret.add(node);
                    }
                }
            }
            return ret;
        }

        return new ArrayList<>();

    }

    public static void main(String[] args){
        new AllSearchTree().generateTrees(2);
    }
}
