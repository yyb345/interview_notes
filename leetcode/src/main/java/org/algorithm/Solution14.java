package org.algorithm; /**
 * Created by yangyibo
 * Date: 2019/4/6
 * Time: 下午3:32
 */
import java.util.ArrayList;
import java.util.Arrays;


public class Solution14 {
	public ArrayList<Integer> printMatrix(int [][] matrix) {
		ArrayList<Integer> ret=new ArrayList<>();
		int m=matrix.length;
		int n=matrix[0].length;


		int step=0;
		while(2*step<Math.min(m,n)){
			//i,j start节点
			// 右
			int r1=step;
			int r2=m-step-1;

			int c1=step;
			int c2=n-step-1;
			//右边
			if(c1<=c2){
				for(int k=c1;k<=c2;k++){
					ret.add(matrix[c1][k]);
				}

				//下
				for(int k=r1+1;k<=r2;k++){
					ret.add(matrix[k][c2]);
				}
			}





			if(c1<c2 && r1<r2){
				//左
				for(int k=c2-1;k>=c1;k--){
					ret.add(matrix[r2][k]);
				}


				//上
				for(int k=r2-1;k>r1;k--){
					ret.add(matrix[k][c1]);
				}
			}


			step++;
		}

		return ret;
	}

	public int StrToInt(String str) {

		if (str == null || str.length() == 0)
			return 0;

		int sum=1;
		int ret=0;
		if(str.charAt(0)=='-')
			sum=-1;
		for(int i=0;i<str.length();i++){
			char c=str.charAt(i);
			if(i==0 && (c=='+' || c=='-'))
				continue;

			if(c<'0' || c>'9')
				return 0;

			ret=ret*10+(c-'0');

		}

		return ret*sum;

	}

	public String LeftRotateString(String str,int n) {

		if(str.length()<=n)
			return  str;
		char[] chars = str.toCharArray();
		reverse(chars,0,n-1);
		reverse(chars,n,chars.length-1);
		reverse(chars,0,chars.length-1);

		return new String(chars);
	}

	void reverse(char[] chars,int i,int j){

		for(int s=i;i<j;s++,j--){
			char c=chars[s];
			chars[s]=chars[j];
			chars[j]=c;
		}

	}




	public static void main(String[] args){
		int[] nums = new int[]{1,5,9};
		System.out.println(Arrays.binarySearch(nums,0,2,1));
		System.out.println(Arrays.binarySearch(nums,0,2,3));
		System.out.println(Arrays.binarySearch(nums,0,2,6));
		System.out.println(Arrays.binarySearch(nums,0,2,10));
	}
}
