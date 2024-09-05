package leetcode.binarytree.bsf;

import leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//TODO
public class LargestValues {

    public static List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> treeNode = new LinkedList<>();
        Queue<TreeNode> tree2 = new LinkedList<>();
        Queue<TreeNode> tmp = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        if (root != null) {

            treeNode.add(root);
            while (treeNode.size() > 0) {

                int maxValue = Integer.MIN_VALUE;
                boolean yes = false;

                while (treeNode.size() > 0) {
                    TreeNode pop = treeNode.poll();
                    if (pop != null) {
                        if (pop.left != null) {
                            tree2.add(pop.left);
                        }
                        if (pop.right != null) {
                            tree2.add(pop.right);
                        }
                        if (pop.val > maxValue) {
                            maxValue = pop.val;
                            yes = true;
                        }
                    }


                }
                if (yes) {
                    result.add(maxValue);
                }
                treeNode = tree2;
                tree2 = new LinkedList<>();
            }


        }
        return result;
    }
}
