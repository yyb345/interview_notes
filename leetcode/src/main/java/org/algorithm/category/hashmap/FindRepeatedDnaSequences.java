package org.algorithm.category.hashmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 187
 * DNA序列，有重复的10个连续字符串
 */
public class FindRepeatedDnaSequences {

    public List<String> findRepeatedDnaSequences(String s) {

        Set<String> set = new HashSet<>();
        Set<String> ret = new HashSet<>();

        for(int i=0;i+9<s.length();i++){
            String windowStr = s.substring(i, i + 10);
            if(!set.add(windowStr)){
                ret.add(windowStr);
            }
        }
        return new ArrayList<>(ret);

    }

    public static void main(String[] args) {
        List<String> list = new FindRepeatedDnaSequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println(list);
    }
}
