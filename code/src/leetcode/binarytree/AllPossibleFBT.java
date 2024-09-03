package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFBT {

    public static List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> result = new ArrayList();

        int subTotal = N - 1;
        int i = 0;
        int left = 0;
        int right = 0;


        if (N == 1) {
            TreeNode tmp = new TreeNode(0);
            result.add(tmp);
        } else {
            while (left < subTotal) {

                left = 2 * i + 1;
                right = subTotal - left;
                List<TreeNode> leftTreeNodes = allPossibleFBT(left);
                List<TreeNode> rightTreeNodes = allPossibleFBT(right);

                for (TreeNode l : leftTreeNodes) {
                    for (TreeNode r : rightTreeNodes) {
                        TreeNode tmp = new TreeNode(0);
                        tmp.left = l;
                        tmp.right = r;
                        result.add(tmp);
                    }
                }
                i++;
                left = 2 * i + 1;
            }
        }

        return result;
    }
}
