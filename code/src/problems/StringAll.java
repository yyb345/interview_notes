package problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yangyibo
 * Date: 2019/3/29
 * Time: 下午6:01
 */
public class StringAll {

	ArrayList<String> result=new ArrayList<>();
	public ArrayList<String> Permutation(String str) {

		if(str==null || str.length()==0)
			return result;

		char[] chars = str.toCharArray();
		boolean[] visited=new boolean[chars.length];
		Arrays.sort(chars);
		//List<Character> currentString =new ArrayList<>();

		StringBuilder currentString=new StringBuilder();
		DFS(chars,currentString,visited);

		return  result;

	}

	public void  DFS(char[]chars,StringBuilder currentString,boolean[] visited){


		if(currentString.length()==chars.length){
			result.add(currentString.toString());
			return;
		}


		for(int i=0;i<chars.length;i++){
			if(i>0 && chars[i]==chars[i-1] && visited[i-1]!=true )
				continue;
			if(visited[i])
				continue;

			visited[i]=true;
			currentString.append(chars[i]);
			DFS(chars,currentString,visited);
			currentString.deleteCharAt(currentString.length()-1);
			visited[i]=false;

		}

	}

	public static void  main(String[] args){
		ArrayList<String> aaa = new StringAll().Permutation("ab");
		System.out.println(aaa);
	}
}
