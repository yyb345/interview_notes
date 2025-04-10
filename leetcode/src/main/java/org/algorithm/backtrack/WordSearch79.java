package org.algorithm.backtrack;

/**
 * leetcode 79
 */
public class WordSearch79 {

    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                // 该节点为起点
                if(backTrack(board,word,i,j,0,visited)){
                    return true;
                }
            }
        }

        return false;
    }

    boolean backTrack(char[][] board,String word,int i,int j,int index,boolean[][] visited){

        // 终止条件
        if(index==word.length()){
            return true;
        }

        // 边界条件
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || visited[i][j] ){
            return false;
        }

        if(word.charAt(index)!=board[i][j]){
            return false;
        }

        // 遍历逻辑
        visited[i][j]=true;
        if(backTrack(board,word,i+1,j,index+1,visited)){
            return true;
        }
        if(backTrack(board,word,i,j+1,index+1,visited)){
            return true;
        }
        if(backTrack(board,word,i-1,j,index+1,visited)){
            return true;
        }
        if(backTrack(board,word,i,j-1,index+1,visited)){
            return true;
        }
        visited[i][j]=false;

        return false;
    }
}
