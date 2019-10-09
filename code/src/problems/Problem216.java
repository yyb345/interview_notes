package problems;

import java.util.*;

/**
 * Created by yangyibo
 * Date: 2019/3/29
 * Time: 下午5:33
 */
public class Problem216 {


	List<List<Integer>> result=new ArrayList<>();
	public List<List<Integer>> combinationSum3(int k, int n) {

		List<Integer> currentList=new ArrayList<>();
		DFS(k,n,1,currentList);
		return result;
	}

	public int FirstNotRepeatingChar(String str) {
		BitSet b1=new BitSet(256);
		BitSet b2=new BitSet(256);
		for(Character c:str.toCharArray()){
			if(!b1.get(c) && !b2.get(c) )
				b1.set(c);
			if(b1.get(c) && !b2.get(c))
				b2.set(c);
		}


		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(b1.get(c) && !b2.get(c) )
				return  i;
		}
		return -1;
	}

	// start 从第几个开始
	public void DFS(int k,int n,int start,List<Integer> currentList){

		if(k<0 || n<0)
			return;

		if(k==0 && n==0){
			result.add(new ArrayList<>(currentList));
			return;
		}


		for(int i=start;i<=9;i++){
			currentList.add(i);
			DFS(k-1,n-i,i+1,currentList);
//			currentList.remove(i);
			currentList.remove(currentList.size()-1);
		}
	}
}
