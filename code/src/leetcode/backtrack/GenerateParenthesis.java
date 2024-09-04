package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

//TODO  重写一下
public class GenerateParenthesis {

    List<String> finalKuo = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        generateKuo("",n,n);
        return finalKuo;
    }


    void generateKuo(String curStr,int left,int right){
        if( left<0 || right<0 || left>right){
            return;
        }

        if(left==0 && right==0){
            finalKuo.add(curStr);
            return;
        }
        generateKuo(curStr+"(",left-1,right);
        generateKuo(curStr+")",left,right-1);
    }
}
