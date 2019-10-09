package problems;

import java.util.*;

/**
 * Created by yangyibo
 * Date: 2019/4/3
 * Time: 下午4:48
 */
public class Solution7 {
	int m=0,n=0;
	int[][] direction=new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
	{

		m=rows;
		n=cols;
		char[][] charMatrix=new char[rows][cols];
		boolean[][] visited=new boolean[rows][cols];
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				charMatrix[i][j]=matrix[i*cols+j];
			}
		}
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(DFS(charMatrix,visited,i,j,str,0))
					return true;
			}
		}


		return false;
	}

	public boolean DFS(char[][] matrix,boolean[][] visited,int row,int col,char[] str,int index){
		boolean result=false;

		if(row==m || col==n || visited[row][col])
			return false;
		if(str[index]!=matrix[row][col])
			return false;
		if(index==str.length-1)
			return true;

		visited[row][col]=true;
		for(int[] d:direction){
			result=result || DFS(matrix,visited,row+d[0],col+d[1],str,index+1);
		}
		visited[row][col]=false;

		return result;
	}


	public boolean wordBreak(String s, Set<String> dict) {

		boolean ret=false;
		if(s.length()==0)
			return true;

		boolean has=false;
		for(String dic:dict){
			int index = s.indexOf(dic);
			if(index!=-1){
				has=true;
				s.replaceFirst(dic,"");
				ret|=wordBreak(s,dict);
				if(ret)
					break;

			}
		}
		if(!has)
			return false;

		return ret;


	}

	String[] table=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	List<String> ret=new ArrayList<>();
	public List<String> letterCombinations(String digits) {

		boolean[] visited=new boolean[digits.length()];
		List<String> list=new ArrayList<>();
		backTracking(digits,0,visited,list);
		return ret;

	}

	public  void backTracking(String digits,int start,boolean[] visited,List<String> list){

		//List<String> ret=new ArrayList<>();

		if(list.size()==digits.length()){
			StringBuilder s=new StringBuilder() ;
			for(String l:list){
				s.append(l);
			}
			ret.add(s.toString());
		}


		for(int i=start;i<digits.length();i++){
			if(!visited[i]){
				int num=Integer.parseInt(digits.substring(i,i+1));
				String letters=table[num];
				for(int k=0;k<letters.length();k++){
					visited[i]=true;
					list.add(letters.substring(k,k+1));
					backTracking(digits,i+1,visited,list);
					list.remove(list.size()-1);
					visited[i]=false;
				}
			}


		}

	}

	public static void main(String[] args){


		new Solution7().letterCombinations("23");
		//System.out.println(hashMap.get(3));

	}
}
