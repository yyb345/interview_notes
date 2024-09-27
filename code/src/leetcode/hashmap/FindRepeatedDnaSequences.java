package leetcode.hashmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 187
 */
public class FindRepeatedDnaSequences {

    public List<String> findRepeatedDnaSequences(String s) {

        Set<String> set = new HashSet<>();
        List<String> ret = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            if(i+10>s.length()){
                break;
            }
            String windowStr = s.substring(i, i + 10);
            if(set.contains(windowStr)){
                if(!ret.contains(windowStr)){
                    ret.add(windowStr);
                }
            }
            set.add(windowStr);
        }

        return ret;
    }

    public static void main(String[] args) {
        List<String> list = new FindRepeatedDnaSequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println(list);
    }
}
