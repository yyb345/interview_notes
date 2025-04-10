package org.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/** 77
 * time complexity O(K*combine(N,K))
 * space complexity O(K*combine(N,K))
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 * You may return the answer in any order.
 * Example 1:
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 * Example 2:
 *
 * Input: n = 1, k = 1
 * Output: [[1]]
 * Explanation: There is 1 choose 1 = 1 total combination.
 */
public class Combinations77 {

    List<List<Integer>> ret = new ArrayList<>();
    int N;
    int K;
    public List<List<Integer>> combine(int n, int k) {
        N=n;
        K=k;
        backTrack(1,new ArrayList<>());
        return ret;
    }

    void backTrack(int i, List<Integer> list){
        if(list.size()==K){
            ret.add(new ArrayList<>(list));
            return;
        }
        for(int j=i;j<=N;j++){
            list.add(j);
            backTrack(j+1,list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new Combinations77().combine(4, 2);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }
}
