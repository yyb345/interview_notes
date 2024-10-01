package org.algorithm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 44
 * 去重
 */
public class CombinationSumII {

    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {


        boolean[] visited = new boolean[candidates.length];
        Arrays.sort(candidates);
        backTrack(candidates,target,0,visited,new ArrayList<>());

        return ret;
    }


    void backTrack(int[] nums, int target,int start,boolean[] visited,List<Integer> list){

        if(target<0){
            return;
        }

        if(target==0){
            ret.add(new ArrayList<>(list));
            return;
        }

        for(int i=start;i<nums.length;i++){
            if(visited[i]){
                continue;
            }

            if(i>0 && !visited[i-1] && nums[i]==nums[i-1]){
                continue;
            }

            visited[i]=true;
            list.add(nums[i]);
            backTrack(nums,target-nums[i],i+1,visited,list);
            list.remove(list.size()-1);
            visited[i]=false;

        }
    }
}
