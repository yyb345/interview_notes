package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculataion {

    public int calculate(String s) {

        String trim = s.trim();

        List<String> dataList = new ArrayList<>();
        List<Character> opList = new ArrayList<>();
        int pre=0;
        for(int i=0;i<trim.length();i++){
            char c = trim.charAt(i);
            if(c=='*' || c=='/' || c=='+' || c=='-' ){
                dataList.add(trim.substring(pre,i));
                opList.add(c);
                pre=i+1;
            }
        }
        dataList.add(trim.substring(pre));



    }

}
