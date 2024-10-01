package org.algorithm.dp;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {

        //

        boolean[] F = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if(wordDict.contains(s.substring(0,i+1))){
                F[i]=true;
            }
            for (int j = 0; j < i; j++) {
                if (F[j] && wordDict.contains(s.substring(j + 1, i + 1))) {
                    F[i] = true;
                }
            }
        }

        return F[s.length() - 1];
    }

    public static boolean wordBreak2(String s, List<String> wordDict) {

        //
        //Set<String> wordSet = new HashSet<>(wordDict);


        boolean[] F = new boolean[s.length()];
        F[0]=wordDict.contains(s.substring(0,1));

        for (int i = 1; i < s.length(); i++) {
            if(wordDict.contains(s.substring(0,i+1))){
                F[i]=true;
                continue;
            }
            for(String word:wordDict){

                if(i>=word.length() && F[i-word.length()] && word.equals(s.substring(i-word.length()+1,i+1))){
                    F[i]= F[i-word.length()];
                }
            }

        }

        return F[s.length() - 1];
    }



    public static void main(String[] args){

        System.out.println(wordBreak2("ab", Arrays.asList("a","b")));
        System.out.println(wordBreak2("leetcode", Arrays.asList("leet","code")));
        System.out.println(wordBreak2("catsandog",Arrays.asList("cats","dog","sand","and","cat")));
        System.out.println(wordBreak2("dogs", Arrays.asList("dog","s","gs")));

    }
}
