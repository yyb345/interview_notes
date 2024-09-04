package leetcode.dfs;

public class MinPath {

    int minSum;
    //leetcode 19
    public void dfsMinPath(int[][] grid,int i,int j,int sum){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length ){
            return;
        }
        sum += grid[i][j];
        if(i==grid.length-1 && j==grid[0].length-1){
            minSum = Math.min(sum,minSum);
            return;
        }
        dfsMinPath(grid,i+1,j,sum);
        dfsMinPath(grid,i,j+1,sum);

    }
}
