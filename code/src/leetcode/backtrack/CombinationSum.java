package leetcode.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO
public class CombinationSum {

    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null || candidates.length==0){
            return new ArrayList<>();
        }

        int m = candidates.length;
        for(int i=0;i<m;i++){
            dfs(i,m,candidates,target,new ArrayList<>());
        }
        return ret;
    }

    void dfs(int i,int m,int[] nums,int target,List<Integer> list) {

        if (i >= m || target < 0) {
            return ;
        }
        if (nums[i] == target) {
            list.add(nums[i]);
            ArrayList<Integer> arrayList = new ArrayList<>(list);
            list.remove(list.size()-1);

            for (List<Integer> successList : ret) {
                if(listCompare(successList,arrayList)){
                    return;
                }
            }
            ret.add(arrayList);
            return ;
        }

        list.add(nums[i]);
        for (int k = 0; k < m; k++) {
            dfs(k, m, nums, target - nums[i], list);
        }
        list.remove(list.size()-1);
    }

    boolean listCompare(List<Integer> list1,List<Integer> list2){
        if(list1.size()!=list2.size()){
            return false;
        }
        Map<Integer,Integer> list1Count = new HashMap<>();
        for (Integer num : list1) {
            if(list1Count.get(num)!=null){
                list1Count.put(num,list1Count.get(num)+1);
            }else {
                list1Count.put(num,1);
            }
        }

        Map<Integer,Integer> list2Count = new HashMap<>();
        for (Integer num : list2) {
            if(list2Count.get(num)!=null){
                list2Count.put(num,list2Count.get(num)+1);
            }else {
                list2Count.put(num,1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : list2Count.entrySet()) {
            if(list1Count.get(entry.getKey())==null || !list1Count.get(entry.getKey()).equals(entry.getValue())){
                return false;
            }
        }
        return true;
    }
}
