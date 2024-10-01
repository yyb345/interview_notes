package org.algorithm.dp;


/**
 * 221
 */
public class MaxSquare {

    public int maximalSquare(char[][] matrix) {


        //F[i][j]>0 代表是以它为右下角的正方形为1
        // F[i-1][j] F[i][j-1] F[i-1][j-1]都为1，则+1

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] F = new int[m][n];

        int max = 0;
        for(int i=0;i<m;i++){
            F[i][0]=matrix[i][0]=='1'?1:0;
            max = Math.max(max,F[i][0]);
        }

        for(int j=0;j<n;j++){
            F[0][j]=matrix[0][j]=='1'?1:0;
            max = Math.max(max,F[0][j]);
        }


        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]=='1'){
                    F[i][j]=Math.min(F[i-1][j],Math.min(F[i][j-1], F[i-1][j-1]))+1;
                    max = Math.max(max,F[i][j]);
                }
            }
        }

        return max*max;

    }
}
