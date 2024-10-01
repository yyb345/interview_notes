package org.algorithm.hashmap;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static int  lengthOfLongestSubstring(String s) {

        if(s==null || s.length()==0){
            return 0;
        }
        // start  end
        // 如何更新这个窗口
        //
        int startIndex = 0;
        int endIndex = 0;
        int max = 1;
        Map<Character,Integer> map = new HashMap<>();

        //
        for(int i=0;i<s.length();i++){
            endIndex = i;
            char endChar =  s.charAt(i);
            if(map.get(endChar)!=null){
                //  包含
                startIndex = Math.max(startIndex,map.get(endChar)+1);
                //
            }
            map.put(endChar,i);

            max = Math.max(max,endIndex-startIndex+1);

        }

        return max;
    }
}
