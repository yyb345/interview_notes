package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyibo
 * Date: 2018/12/19
 * Time: 下午10:33
 */
public class TwoPoint {

	// problem 763 Partition Labels
	public static List<Integer> partitionLabels(String S) {

		List<Integer> result=new ArrayList<>();
		List<String> paritions=new ArrayList<>();
		for(int i=0;i<S.length();i++){
			String ss = S.substring(i, i + 1);
			if(paritions.size()>0){
				int index;
				for(index=0;index<paritions.size() && !paritions.get(index).contains(ss);index++){
				}
				if(index==paritions.size()){
					paritions.add(ss);
				}else{
					String tmp=ss;
					for(int j=paritions.size()-1;j>=index;j--){
						String remove = paritions.remove(j);
						tmp=remove+tmp;
					}
					paritions.add(tmp);
				}
			}else{
				paritions.add(ss);
			}
		}

		for(String k:paritions){
			result.add(k.length());
		}

		return result;
	}

	public static void main(String []args){
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);

		System.out.println(list);
		list.remove(1);
		list.add(1,4);
		System.out.println(list);
	}
}
