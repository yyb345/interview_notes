package problems;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by yangyibo
 * Date: 2019/4/3
 * Time: 下午9:15
 */
public class Solution10 {
	public int GetUglyNumber_Solution(int index) {


		if(index<1)
			return 0;

		int[] dp=new int[index+1];
		dp[1]=1;
		int pre2=1;
		int pre3=1;
		int pre5=1;
		for(int i=2;i<=index;i++){
			dp[i]=Math.min(dp[pre2]*2,Math.min(dp[pre3]*3,dp[pre5]*5));
			if(dp[i]==(dp[pre2]*2))
				pre2++;
			if(dp[i]==(dp[pre3]*3))
				pre3++;
			 if(dp[i]==(dp[pre5]*5))
				pre5++;

		}

		return dp[index];
	}

	public ArrayList<Integer> maxInWindows(int [] num, int size) {

		if( num==null || num.length<size)
			return null;

		ArrayList<Integer> ret=new ArrayList<>();

		Queue<Integer> heap=new PriorityQueue<>(((o1, o2) -> o2-o1));
		for(int i=0;i<size;i++)
			heap.add(num[i]);
		ret.add(heap.peek());


		int i=0,j=i+size;
		while(j<num.length){
			heap.remove(num[i]);
			heap.add(num[j]);
			ret.add(heap.peek());
			i++;
			j++;
		}

		return ret;


	}


	public static void main(String[] args){
		int[] num=new int[]{2,3,4,2,6,2,5,1};
		new Solution10().maxInWindows(num,3);
		//Queue<Integer> integers=new PriorityQueue<>(((o1, o2) -> o2-o1));
	}
}
