package org.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyibo
 * Date: 2019/5/5
 * Time: 下午12:42
 */
public class Solutio55 {


	public int repeatedStringMatch(String A, String B) {

		if(A==null || B==null || B.length()==0 || A.length()==0)
			return  -1;

		List<Integer>  indexs=new ArrayList<>();
		for(int k=0;k<A.length();k++){
			if(B.charAt(0)==A.charAt(k)){
				indexs.add(k);
			}
		}
		 boolean yes=false;

		    int j=0;
			for(int index:indexs){
			    int i=0;
				j=index;
				while(i<B.length()){
						if(A.charAt((j)%A.length())!=B.charAt(i)){
							break;
						}else {
							j++;
							i++;
						}
				}

				if(i==B.length())
				{
					yes=true;
					break;
				}


			}


			if(yes){
				return ((j-1)/A.length()+1);
			}else {
				return -1;
			}







	}

	public static void main(String[] args){
		System.out.println(new Solutio55().repeatedStringMatch("a","aa"));
	}

}
