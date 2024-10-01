package org.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 46 数组全排列
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Permute {

    List<List<Integer>> ret  = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums==null || nums.length==0){
            return new ArrayList<>();
        }

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
            visited[i]=true;
            list.add(nums[i]);
            backTrack(nums,visited,list);
            list.remove(list.size()-1);
            visited[i]=false;
        }

    }
}
