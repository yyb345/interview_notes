package problems;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if (n > 0) {

            int[] nums = new int[n];
            for (int k = 0; k < n; k++) {
                nums[k] = in.nextInt();
            }


            int[][] min = new int[n][n];
            int[][] sum = new int[n][n];
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                min[i][i] = nums[i];
                sum[i][i] = nums[i];
                int tmp = min[i][i] * sum[i][i];
                if (tmp > maxValue)
                    maxValue = tmp;
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    min[i][j] = Math.min(min[i][j - 1], nums[j]);
                    sum[i][j] = sum[i][j - 1] + nums[j];
                    int tmp = min[i][j] * sum[i][j];
                    if (tmp > maxValue)
                        maxValue = tmp;
                }
            }

            System.out.println(maxValue);

        }else{
            System.out.println(0);
        }
    }

}

    //        int[] value=new int[]{1,5,10,20,50,100};
//        int[] dp=new int[n+1];
//
//
//       dp[0]=1;
//
//        for(int j=0;j<value.length;j++){
//            for(int i=1;i<=n;i++){
//                if(i>=value[j]){
//                    dp[i]+=dp[i-value[j]];
//                }
//
//            }
//        }
//        System.out.println(dp[n]);

