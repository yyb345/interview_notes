package org.algorithm.category.binarytree.bst;

/**
 * 96
 * 给定一个数字N，那么从1->N个元素,可以组成多少个二叉搜索树
 * 时间复杂度O(N^2) 空间复杂度O(N)
 */
public class AllUniqueBST96 {

    public int numTrees(int n) {
        int[] dp = new int[n+1];

        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i]+= dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
