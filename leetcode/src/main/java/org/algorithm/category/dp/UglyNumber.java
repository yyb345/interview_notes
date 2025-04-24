package org.algorithm.category.dp;

// TODO
public class UglyNumber {

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
}
