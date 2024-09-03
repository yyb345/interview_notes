package tool;

import treeproblem.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTool {

    //[1,2,3,null,4,null,null]
    public static TreeNode buildTree(Integer[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0 || levelOrder[0] == null) return null;

        TreeNode root = new TreeNode(levelOrder[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1; // 从数组的第二个元素开始遍历
        while (i < levelOrder.length) {
            TreeNode currentNode = queue.poll();

            // 左子节点
            if (i < levelOrder.length && levelOrder[i] != null) {
                currentNode.left = new TreeNode(levelOrder[i]);
                queue.add(currentNode.left);
            }
            i++;

            // 右子节点
            if (i < levelOrder.length && levelOrder[i] != null) {
                currentNode.right = new TreeNode(levelOrder[i]);
                queue.add(currentNode.right);
            }
            i++;
        }

        return root;
    }


    public static void main(String[] args){
        TreeNode treeNode = buildTree(new Integer[]{1, 2, 3, null, null, 4, 5});

        System.out.println(treeNode.val);
    }


}
