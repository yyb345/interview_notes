package org.algorithm.dfs;

/**
 * 547
 */
public class ProviceNumber {

    public int findCircleNum(int[][] isConnected) {
        int count =0;
        boolean[] visited = new boolean[isConnected.length];
        for(int city=0;city<isConnected.length;city++){
            if(visited[city]){
                continue;
            }
            // 独立的一个城市
            count++;
            // 标记连通城市
            dfs(isConnected,city,visited);
        }
        return count;
    }


    void dfs(int[][] isConnected,int city,boolean[] visited){

        if(visited[city]){
            return;
        }
        visited[city]=true;
        for(int j=0;j<isConnected[0].length;j++){
            if(isConnected[city][j]==1){
                dfs(isConnected,j,visited);
            }
        }
    }
}
