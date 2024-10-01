package org.algorithm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47 数组全排列
 * 去重,比如[1,1,2]
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 */
public class PermuteII {

    List<List<Integer>> ret  = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums==null || nums.length==0){
            return new ArrayList<>();
        }
        // 1. sort
        Arrays.sort(nums);
        int m = nums.length;
        boolean[] visited = new boolean[m];
        backTrack(nums,visited,new ArrayList<>());

        return ret;
    }

    void backTrack(int[] nums,boolean[] visited,List<Integer> list){

        if(list.size()==nums.length){
            ret.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(visited[i]){
                continue;
            }

            // 2. this is keypoint that can remove duplicates
            if(i>0 && !visited[i-1] && nums[i]==nums[i-1]){
                continue;
            }

            visited[i]=true;
            list.add(nums[i]);
            backTrack(nums,visited,list);
            list.remove(list.size()-1);
            visited[i]=false;


        }

    }
}
