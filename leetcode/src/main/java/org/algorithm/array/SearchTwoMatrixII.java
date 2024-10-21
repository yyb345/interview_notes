package org.algorithm.array;

/**
 * 240
 */
public class SearchTwoMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {

        int i=0;
        int j=matrix[0].length-1;

        while(i<matrix.length && j>=0 ){
            if(matrix[i][j]>target){
                j--;
            }else if(matrix[i][j]<target){
                i++;
            }else {
                return true;
            }
        }

        return false;
    }
}
