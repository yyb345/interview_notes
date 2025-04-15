package org.algorithm.hashmap;

/**
 * 383
 * 用26位数组代替HashMap效率更高
 */
public class RansomNote383 {

    public boolean canConstruct(String ransomNote, String magazine) {

        char[] chars = new char[26];
        for(char m:magazine.toCharArray()){
            chars[m-'a']+=1;
        }
        for(char c:ransomNote.toCharArray()){
            if(chars[c-'a']==0){
                return false;
            }
            chars[c-'a']-=1;
        }
        return true;
    }
}
