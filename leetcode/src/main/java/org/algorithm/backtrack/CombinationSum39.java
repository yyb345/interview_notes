package org.algorithm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 39
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 */
public class CombinationSum39 {

    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null || candidates.length==0){
            return new ArrayList<>();
        }

        // 1. 排序
        Arrays.sort(candidates);

        // 2.
        dfs(0,candidates,target,new ArrayList<>());
        return ret;
    }

    void dfs(int start,int[] candidates,int target,List<Integer> list){
        if(target<0){
            return;
        }

        if(target==0){
            ret.add(new ArrayList<>(list));
            return;
        }

        for(int i=start;i<candidates.length;i++){
            list.add(candidates[i]);
            dfs(i,candidates,target-candidates[i],list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new CombinationSum39().combinationSum(new int[]{2, 3, 5}, 8);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }

}
