package leetcode.dp;

public class JumpGame {

    public int jump(int[] nums) {


        int m = nums.length;
        int[] F = new int[m];
        for(int i=0;i<m;i++){
            for(int j=0;j<i;j++){
                if((nums[j]+j)>=i){
                    if(F[i]==0){
                        F[i]=F[j]+1;
                    }else {
                        F[i]=Math.min(F[j]+1,F[i]);
                    }
                }
            }
        }

        return F[m-1];
    }
}
