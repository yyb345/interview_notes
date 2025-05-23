package online;


import org.apache.ecs.html.S;

import java.util.*;

public class CodeProblem {


    public boolean checkInclusion(String s1, String s2) {
        // 1. buildMap
        int[] count1 = buildWindowCount(s1, 0, s1.length() - 1);
        int[] count2 = buildWindowCount(s2, 0, s1.length() - 1);
        if(check(count1, count2)) {
            return true;
        }
        // 2. slide window process
        int l = 1;
        int h = s1.length();
        while (h < s2.length()) {
            count2[s2.charAt(l - 1)-'a']--;
            count2[s2.charAt(h)-'a']++;
            if (check(count1, count2)) {
                return true;
            }
            h++;
            l++;
        }

        return false;
    }

    int[] buildWindowCount(String s, int l, int h) {
        int[] count = new int[26];
        for (int i = l; i <= h && i<s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }
        return count;
    }

    boolean check(int[] count1, int[] count2) {
        for(int i=0;i<26;i++){
            if(count1[i]!=count2[i]){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        HashMap<Integer, Integer> map = new HashMap<>(16);

        for(int i=0;i<16;i++){
            map.put(i,i);
        }
        System.out.println(map.get(40));


    }
}
