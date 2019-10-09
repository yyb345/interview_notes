package problems;

/**
 * Created by yangyibo
 * Date: 2019/3/29
 * Time: 下午4:24
 */
class Solutions {

	int [][]direction=new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
	public int maxAreaOfIsland(int[][] grid) {

		//int value=Integer.MIN_VALUE;
		boolean[][] visited=new boolean[grid.length][grid[0].length];
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				if(!visited[i][j]){
					int value=DFS(grid,i,j,visited);
				}
			}
		}
		return 0;
	}


	public int DFS(int[][] grid,int i,int j,boolean[][] visited){
		int result=1;
		if(i>grid.length || j>grid[0].length )
			return 0;
		visited[i][j]=true;
		if(grid[i][j]==0)
			return 0;

		for(int k=0;k<direction.length;k++){
			if(!visited[i+direction[k][0]][j+direction[k][1]]){
				result+=DFS(grid,i+direction[k][0],j+direction[k][1],visited);
			}
		}

		return result;

	}

	public static  void main(String[] args){

	}
}
