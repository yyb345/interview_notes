package leetcode.dp;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();
        int[][] F = new int[m][n];

        int max = 0;
        F[0][0] = text1.charAt(0)==text2.charAt(0) ? 1:0;
        for(int i=1;i<m;i++){
            F[i][0]= Math.max(F[i-1][0],text1.charAt(i)==text2.charAt(0) ? 1:0);
            max = Math.max(F[i][0],max);
        }

        for(int j=1;j<n;j++){
            F[0][j]= Math.max(F[0][j-1],text1.charAt(0)==text2.charAt(j) ? 1:0);
            max = Math.max(F[0][j],max);
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(text1.charAt(i)==text2.charAt(j)){
                    F[i][j] = F[i-1][j-1]+1;
                }else{
                    F[i][j] = Math.max(F[i][j-1],F[i-1][j]);

                }
                max = Math.max(F[i][j],max);
            }
        }

        return max;

    }
}
