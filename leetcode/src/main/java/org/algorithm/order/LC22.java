package org.algorithm.order;

import java.util.ArrayList;
import java.util.List;

/** 22
 * time complexity O()
 * space complexity O()
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 */
public class LC22 {
    List<String> ret = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        generateKuo("",n,n);
        return ret;
    }


    void generateKuo(String curStr,int left,int right){
        if( left<0 || right<0 || left>right){
            return;
        }

        if(left==0 && right==0){
            ret.add(curStr);
            return;
        }
        generateKuo(curStr+"(",left-1,right);
        generateKuo(curStr+")",left,right-1);
    }
}
