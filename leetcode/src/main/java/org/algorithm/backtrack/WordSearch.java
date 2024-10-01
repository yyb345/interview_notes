package org.algorithm.backtrack;

//TODO 重写一遍
public class WordSearch {

    public static boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<board[0].length;j++){
                boolean[][] travel = new boolean[m][n];
                if(dfs(board,i,j,m,n,travel,word.substring(1))){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean  dfs(char[][] board,int i,int j,int m,int n,boolean[][] travel,String word){
        if(i<0 || j<0 || i>=m || j>=n || travel[i][j]){
            return false;
        }
        if(!word.startsWith(String.valueOf(board[i][j]))){
            return false;
        }
        travel[i][j]= true;
        if(word.length()==1){
            return true;
        }
        String newWord = word.substring(1);
        if(dfs(board,i+1,j,m,n,travel,newWord)){
            return true;
        }
        if(dfs(board,i-1,j,m,n,travel,newWord)){
            return true;
        }
        if(dfs(board,i,j+1,m,n,travel,newWord)){
            return true;
        }

        if(dfs(board,i,j-1,m,n,travel,newWord)){
            return true;
        }
        return false;
    }
}
