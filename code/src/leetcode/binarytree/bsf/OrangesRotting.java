package leetcode.binarytree.bsf;

import java.util.LinkedList;
import java.util.Queue;
// 994
//TODO
public class OrangesRotting {

    Queue<Node> nodeQueue = new LinkedList<>();
    int rr = -1;


    class Node {
        int x;
        int y;
        Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    // 994
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] travel = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    nodeQueue.add(new Node(i,j));
                    travel[i][j] = true;
                }else if(grid[i][j]==0){
                    travel[i][j] = true;
                }
            }
        }

        bfs(grid,travel,m,n);
        // 判断，如果还存在1，则返回-1

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!travel[i][j]){
                    return -1;
                }
            }
        }

        return rr;
    }


    void bfs(int[][] grid,boolean[][] travel,int m,int n){
        while(!nodeQueue.isEmpty()){
            int size = nodeQueue.size();
            for(int k=0;k<size;k++){
                Node node =  nodeQueue.poll();
                int i=node.x;
                int j = node.y;
                travelNode(i+1,j,grid,travel,m,n);
                travelNode(i-1,j,grid,travel,m,n);
                travelNode(i,j+1,grid,travel,m,n);
                travelNode(i,j-1,grid,travel,m,n);
            }
            rr++;
        }
    }

    void travelNode(int i,int j,int[][] grid,boolean[][] travel,int m,int n){
        if(i<0 || j<0 || i>=m || j>=n  || travel[i][j]){
            return;
        }

        nodeQueue.add(new Node(i,j));
        travel[i][j] = true;
    }
}
