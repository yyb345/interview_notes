package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

//TODO  重写一下
public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        List<String> strings = subGenet(n - 1, n);
        for (String l : strings) {
            result.add("(" + l);
        }
        return result;
    }

    public static List<String> subGenet(int left, int right) {
        List<String> result = new ArrayList<>();
        int leftRemaining = left;
        int rightRemaining = right;

        if (leftRemaining > 0 && rightRemaining > 0) {
            // 一条路径 C
            List<String> leftStrings = subGenet(leftRemaining - 1, rightRemaining);
            for (String l : leftStrings) {
                result.add("(" + l);
            }
            //另一条路径 )
            if (rightRemaining > leftRemaining) {
                List<String> rightStrings = subGenet(leftRemaining, rightRemaining - 1);
                for (String r : rightStrings) {
                    result.add(")" + r);
                }
            }

        } else if (leftRemaining == 0 && rightRemaining > 0) {

            // 一条路径，)
            List<String> rightStrings = subGenet(leftRemaining, rightRemaining - 1);
            for (String r : rightStrings) {
                result.add(")" + r);
            }
        } else if (leftRemaining == 0 && rightRemaining == 0) {
            result.add("");
        }


        return result;

    }
}
