package org.algorithm.dp;

import java.util.Arrays;

public class MaxProfit {

    // problem  121
    public static int maxProfit(int[] prices) {

        if (prices.length > 1) {
            int[] tmp = new int[prices.length - 1];
            for (int i = 0; i < prices.length - 1; i++) {
                tmp[i] = prices[i];
            }

            int min = Arrays.stream(tmp).min().getAsInt();
            int value = Math.max((prices[prices.length - 1] - min), maxProfit(tmp));
            return value;
        } else {
            int value = 0;
            return value;
        }
    }

    public int maxProfitV2(int[] prices) {

        int n = prices.length;
        int[] dp = new int[n];

        int min=prices[0];
        int max = 0;

        for(int i=1;i<n;i++){
            dp[i]= Math.max(prices[i]-min,0);
            min = Math.min(min,dp[i]);
            max = Math.max(max,dp[i]);
        }

        return max;
    }
}
