package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

//TODO 重写一下
public class Permute {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length > 1) {
            for (int i = 0; i < nums.length; i++) {
                int[] subNums = new int[nums.length - 1];
                int index = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (i != j) {
                        subNums[index++] = nums[j];
                    }
                }
                List<List<Integer>> permute = permute(subNums);
                for (List<Integer> d : permute) {
                    d.add(nums[i]);
                    result.add(d);
                }
            }
        } else if (nums.length == 1) {
            List<Integer> dd = new ArrayList<>();
            dd.add(nums[0]);
            result.add(dd);
        }


        return result;
    }
}
