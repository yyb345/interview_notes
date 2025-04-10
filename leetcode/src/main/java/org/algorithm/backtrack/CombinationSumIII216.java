package org.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 216
 */
public class CombinationSumIII216 {

    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<Integer> currentList=new ArrayList<>();
        DFS(k,n,1,currentList);
        return result;
    }

    // start 从第几个开始
    public void DFS(int k, int n, int start, List<Integer> currentList){

        if(k<0 || n<0)
            return;

        if(k==0 && n==0){
            result.add(new ArrayList<>(currentList));
            return;
        }


        for(int i=start;i<=9;i++){
            currentList.add(i);
            DFS(k-1,n-i,i+1,currentList);
            currentList.remove(currentList.size()-1);
        }
    }
}
