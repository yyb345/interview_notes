package org.algorithm.category.dfs;

/**
 * 200
 * 计算island数量
 */
public class NumIsland {

    public int numIslands(char[][] grid) {
        int count=0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,m,n,grid);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(int i,int j, int m,int n,char[][] grid){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        dfs(i+1,j,m,n,grid);
        dfs(i-1,j,m,n,grid);
        dfs(i,j+1,m,n,grid);
        dfs(i,j-1,m,n,grid);
    }
}
