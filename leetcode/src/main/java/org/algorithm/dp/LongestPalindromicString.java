package org.algorithm.dp;

/**
 * 5
 */
public class LongestPalindromicString {

    public String longestPalindrome(String s) {

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] ret = new int[]{0,0};

        int maxLen = 0;
        for(int i=0;i<n;i++){
            dp[i][i]=true;
            for(int j=0;j<i;j++){
                if(s.charAt(j)==s.charAt(i)){
                    if(i-j<=2 || dp[j+1][i-1]){
                        dp[j][i] = true;
                        if(i-j+1>maxLen){
                            maxLen = i-j+1;
                            ret = new int[]{j,i};
                        }
                    }
                }
            }
        }

        return s.substring(ret[0],Math.min(ret[1]+1,s.length()));
    }
}
