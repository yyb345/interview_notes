package generic;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class MathNumber {

    int val;

   public MathNumber(int val){
        this.val=val;
    }

   public void sub(int num){
       this.val=this.val-num;
   }


    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public boolean isHappy(int n) {

        if(n==1){
            return true;
        }

        if(n<10){
            return false;
        }

        String nstr = String.valueOf(n);
        int sum=0;
        List<Integer> numList = new ArrayList<>();
        for(int i=0;i<nstr.length();i++){
            numList.add(Integer.parseInt(nstr.substring(i,i+1)));
        }
        for(int num:numList){
            sum+=(num*num);
        }

        return isHappy(sum);
    }

    public static int maxSubArray(int[] nums) {

        // F[N]= max(F[N-1],{nums[N]+...})


        if(nums==null || nums.length==0){
            return 0;
        }
        int m = nums.length;
        int[] F = new int[m];
        F[0]=nums[0];
        for(int i=1;i<m;i++){
            int preSum = 0;
            F[i]=F[i-1];
            for(int j=i;j>=0;j--){
                preSum+=nums[j];
                F[i]=Math.max(F[i],preSum);
            }
        }

        return F[m-1];
    }
   public static void main(String[] args){

       System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
       System.out.println(maxSubArray(new int[]{1}));
       System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));


   }


}
