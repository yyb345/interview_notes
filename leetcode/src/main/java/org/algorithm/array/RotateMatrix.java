package org.algorithm.array;


/**
 * 48
 * 旋转90度
 */
public class RotateMatrix {


    public void rotate(int[][] matrix) {


        int n = matrix.length;
        // 270 度翻转
        int l=0,h=n-1;
        while(l<h){
            // swap(matrix[l],matrix[h]);
            for(int k=0;k<n;k++){
                int tmp = matrix[l][k];
                matrix[l][k] = matrix[h][k];
                matrix[h][k] = tmp;
            }
            l++;
            h--;
        }

        // 180度翻转
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                // swap [i][j] <=> [j][i]
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
