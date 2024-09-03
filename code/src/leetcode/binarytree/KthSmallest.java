package leetcode.binarytree;

import leetcode.Solution;
import treeproblem.TreeNode;

import java.util.*;

//TODO 重写一下
public class KthSmallest {

    public static int kthSmallest(TreeNode root, int k) {

        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> values = new ArrayList<>();
        while (queue.size() > 0) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                queue.add(poll.left);
                values.add(poll.val);
            }
            if (poll.right != null) {
                queue.add(poll.right);
                values.add(poll.val);
            }
        }
        Object[] objects = values.toArray();
        Arrays.sort(objects);
        int object = (int) objects[k - 1];

        result = object;

        return result;
    }
}
