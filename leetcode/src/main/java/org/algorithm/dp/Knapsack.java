package org.algorithm.dp;

public class Knapsack {

    public int knapsack (int V, int n, int[][] vw) {
        // write code here
        int[] f= new int[V+1];
        for(int i=0;i<=V;i++){
            f[i]=0;
        }
        int max = 0;

        for(int j=0;j<n;j++) {
            for (int i = 0; i <= V; i++) {
                if (i >= vw[j][0]) {
                    f[i] = Math.max(f[i], f[i - vw[j][0]] + vw[j][1]);
                }
            }
        }

        return f[V];
    }
}
