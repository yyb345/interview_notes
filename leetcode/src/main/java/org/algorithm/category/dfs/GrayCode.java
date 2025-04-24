package org.algorithm.category.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 89
 * 格雷编码，可以拆解子问题
 *
 * [0,1]->[11,10]->[110,111,101,100]
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {

        return dfs(n);
    }

    // 拆解为子问题
    List<Integer> dfs(int n){

        if(n==1){
            return Arrays.asList(0,1);
        }

        List<Integer> sublist = dfs(n-1);

        List<Integer> nList= new ArrayList<>(sublist);
        for(int i=sublist.size()-1;i>=0;i--){
            // 核心
            nList.add(sublist.get(i)+(1<<n-1));
        }

        return nList;
    }
}
