package org.algorithm.category.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 78
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class Subsets78 {

    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

        backTrack(nums,0,new ArrayList<>(),nums.length);
        return ret;
    }

    void backTrack(int[] nums,int start,List<Integer> list,int k){

        ret.add(new ArrayList<>(list));

        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            backTrack(nums,i+1,list,k-1);
            list.remove(list.size()-1);
        }

    }
}
