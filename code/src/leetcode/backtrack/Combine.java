package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

//TODO
public class Combine {

    List<List<Integer>> ret = new ArrayList<>();
    int N=0;
    int K=0;
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
        for(int j=i;j<N;j++){
            list.add(j);
            backTrack(j,list);
            list.add(list.size()-1);
        }
    }
}
