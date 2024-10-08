package org.algorithm.binarysearch;

import java.util.Arrays;

/**
 * 74
 * 2D 矩阵搜索值
 * 1234  l->r 递增
 * 5678  up->down 递增
 * 二维矩阵拆解成一维矩阵的递增
 */
public class TwoDMatrixSearch {

    public boolean searchMatrix(int[][] matrix, int target) {

        int l = 0;
        int h = matrix.length*matrix[0].length-1;

        while(l<=h){
            int mid = l+(h-l)/2;
            int value = matrix[mid/matrix[0].length][mid%matrix[0].length];
            if(value<target){
                l = mid+1;
            }else if(value>target){
                h = mid-1;
            }else {
                return true;
            }

        }

        return false;
    }


}
