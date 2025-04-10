package org.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 17
 * 给定一个字符串是"数字"，问按键有多少种组合
 */
public class LetterCombinations17 {

    String[] table = new String[]{"abc","def","ghi","jkl","mno", "pqrs","tuv","wxyz"};

    List<String> ret = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0){
            return new ArrayList<>();
        }
        backTrack(digits,0,new StringBuffer());
        return ret;
    }

    void backTrack(String digits,int index,StringBuffer sb){

        // 终止条件
        if(index>digits.length()){
            return;
        }
        // 满足条件
        if(index==digits.length()){
            ret.add(sb.toString());
            return;
        }
        int num = digits.charAt(index)-'2';
        for(int i=0;i<table[num].length();i++){
            sb.append(table[num].charAt(i));
            backTrack(digits,index+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
