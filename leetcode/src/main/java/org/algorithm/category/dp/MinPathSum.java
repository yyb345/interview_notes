package org.algorithm.category.dp;

// 64
public class MinPathSum {

    int minSum = Integer.MAX_VALUE;

    public int minPathSum(int[][] grid) {

        if(grid==null || grid.length==0){
            return -1;
        }
        int[][] dp = new int[grid.length][grid[0].length];

        int m = grid.length;
        int n = grid[0].length;

        dp[0][0]=grid[0][0];
        for(int j=1;j<n;j++){
            dp[0][j]=grid[0][j]+dp[0][j-1];
        }

        for(int i=1;i<m;i++){
            dp[i][0]=grid[i][0]+dp[i-1][0];
        }

        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }

        return dp[grid.length-1][grid[0].length-1];
    }
}
