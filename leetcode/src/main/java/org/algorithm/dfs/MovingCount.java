package org.algorithm.dfs;

public class MovingCount {

    int result = 0;
    public int movingCount(int m, int n, int k) {

        boolean[][] visited = new boolean[m][n];
        moving(0,0,m,n,k,visited);
        return result;
    }


    public void moving(int i,int j,int m,int n,int k,boolean[][] visited){
        if(i<0 || j<0 || i>=m || j>=n  || visited[i][j]){
            return;
        }

        visited[i][j]=true;
        int vv= i/10+i%10+j/10+j%10;
        if(vv>k){
            return;
        }
        result++;
        moving(i+1,j,m,n,k,visited);
        moving(i,j+1,m,n,k,visited);
        moving(i-1,j,m,n,k,visited);
        moving(i,j-1,m,n,k,visited);
    }
}
