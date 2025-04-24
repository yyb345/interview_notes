package org.algorithm.category.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 3
 * 最长不重复子串的长度
 */
public class LengthOfLongestSubstring3 {

    public static int  lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }

        int start = 0;
        int max = Integer.MIN_VALUE;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char cc =  s.charAt(i);
            if(map.get(cc)!=null){
                start = Math.max(start,map.get(cc)+1);
            }
            map.put(cc,i);
            max = Math.max(max,i-start+1);
        }

        return max;
    }

    public int lengthOfLongestSubstringV2(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] charIndex = new int[256];
        for (int i = 0; i < charIndex.length; i++) {
            charIndex[i] = -1;
        }
        int len = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char cc = s.charAt(i);
            // 更新start
            start = Math.max(start, charIndex[cc] + 1);
            len = Math.max(len, i - start + 1);
            charIndex[cc] = i;
        }
        return len;
    }
}
