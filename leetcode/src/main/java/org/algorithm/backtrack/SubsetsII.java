package org.algorithm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90
 * 去重
 */
public class SubsetsII {

    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums, 0, visited, new ArrayList<>(), nums.length);
        return ret;
    }

    void backTrack(int[] nums, int start, boolean[] visited, List<Integer> list, int k) {

        ret.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {

            // 去重
            if (i>0 && !visited[i-1] && nums[i-1] == nums[i]) {
                start++;
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            backTrack(nums, i + 1, visited, list, k - 1);
            list.remove(list.size() - 1);
            visited[i] = false;
        }

    }
}
