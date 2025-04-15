package org.algorithm.str;

import java.util.Arrays;

/**
 * 14
 * 最长公共前缀
 * 解法：1.数组先排序 2. 只需要对比第一个字符串和最后一个字符串即可
 */
public class LongestCommonPrefix14 {

    public String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Math.min(first.length(),last.length());i++){
            if(first.charAt(i)==last.charAt(i)){
                sb.append(first.charAt(i));
            }else{
                break;
            }
        }
        return sb.toString();

    }
}
