package org.algorithm.dfs;

/**
 * 题号 695
 * [1,1,0,0,0],
 * [1,1,0,0,0],
 * [0,0,0,1,1],
 * [0,0,0,1,1]
 * 题目maxArea，也就是岛屿1最多的数量
 */
public class MaxAreaOfIsland {

    int[][] direction=new int[][]{{0,-1},{0,1},{1,0},{-1,0}};


    int num=0;
    public  int maxAreaOfIsland(int[][] grid) {

        int max=0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    num=0;
                    DFS(grid,i,j,visited);
                    max=Math.max(max,num);
                }
            }
        }
        return max;
    }

    private void DFS(int[][] grid,int i,int j,boolean[][] visited){

        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j])
            return;
        if(grid[i][j]==0)
            return;

        visited[i][j]=true;
        num++;

        for(int k=0;k<direction.length;k++){
            DFS(grid,i+direction[k][0],j+direction[k][1],visited);
        }
    }

    public static void main(String[] args) {

        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        System.out.println(maxAreaOfIsland.maxAreaOfIsland(new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}}));
//        System.out.println(maxAreaOfIsland.maxAreaOfIsland(new int[][]{{1,0,1,1,1},{1,1,1,1,1}}));
//        System.out.println(maxAreaOfIsland.maxAreaOfIsland(new int[][]{{1,0,1,1,1},{1,0,1,1,1}}));
//        System.out.println(maxAreaOfIsland.maxAreaOfIsland(new int[][]{{0,0,0,0,0}}));
    }
}
