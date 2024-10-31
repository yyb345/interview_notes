package org.algorithm.binarytree.bst;

import java.util.HashMap;
import java.util.Map;

/**
 * 96
 */
public class AllUniqueBST {

    Map<Integer,Integer> map = new HashMap<>();
    public int numTrees(int n) {

        return dfs(n);
    }

    int dfs(int n){

        if(n==0){
            return 1;
        }

        if(n==1){
            return 1;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        int count=0;
        for(int i=1;i<=n;i++){
            int left = dfs(i-1);
            int right = dfs(n-i);
            count += left * right;
        }
        map.put(n,count);
        return count;
    }
}
