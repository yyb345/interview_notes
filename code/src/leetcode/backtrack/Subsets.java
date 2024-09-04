package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

//TODO
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length > 0) {
            int[] subNums = new int[nums.length - 1];
            int lasstElement = nums[nums.length - 1];
            for (int i = 0; i < subNums.length; i++) {
                subNums[i] = nums[i];
            }
            List<List<Integer>> subDatas = subsets(subNums);
            result.addAll(subDatas);

            for (List<Integer> set : subDatas) {
                List<Integer> subb = new ArrayList<>();
                subb.addAll(set);
                subb.add(lasstElement);
                result.add(subb);
            }


        } else {
            result.add(new ArrayList<>());
        }

        return result;
    }
}
