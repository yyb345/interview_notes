package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

//TODO 重新看一下
public class LetterCombinations {

    String[] table=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> ret=new ArrayList<>();
    public List<String> letterCombinations(String digits) {

        boolean[] visited=new boolean[digits.length()];
        List<String> list=new ArrayList<>();
        backTracking(digits,0,visited,list);
        return ret;

    }

    public  void backTracking(String digits,int start,boolean[] visited,List<String> list){

        //List<String> ret=new ArrayList<>();

        if(list.size()==digits.length()){
            StringBuilder s=new StringBuilder() ;
            for(String l:list){
                s.append(l);
            }
            ret.add(s.toString());
        }


        for(int i=start;i<digits.length();i++){
            if(!visited[i]){
                int num=Integer.parseInt(digits.substring(i,i+1));
                String letters=table[num];
                for(int k=0;k<letters.length();k++){
                    visited[i]=true;
                    list.add(letters.substring(k,k+1));
                    backTracking(digits,i+1,visited,list);
                    list.remove(list.size()-1);
                    visited[i]=false;
                }
            }


        }

    }
}
