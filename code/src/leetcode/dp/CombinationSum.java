package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 377
 *
 * Input: nums = [1,2,3], target = 4
 * Output: 7
 * Explanation:
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 */
public class CombinationSum {

     Map<Integer,Integer> map = new HashMap<>();
     public int combinationSum4(int[] nums, int target) {
         if(target<0){
             return 0;
         }
         if(target==0){
             return 1;
         }

         // 记忆化成存储
         if(map.containsKey(target)){
             return map.get(target);
         }

         int sum = 0;
         for(int i=0;i<nums.length;i++){
             sum+=combinationSum4(nums,target-nums[i]);
         }

         map.put(target,sum);
         return sum;
     }


    public int combinationSum4V2(int[] nums, int target) {

        int[] dp = new int[target+1];
        dp[0]=1;
        for(int j=1;j<=target;j++){
            for(int i=0;i<nums.length;i++){
                if(nums[i]<=j){
                    dp[j]+=dp[j-nums[i]];
                }
            }
        }

        return dp[target];
    }

}
