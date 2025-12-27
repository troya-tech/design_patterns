package com.leetcode.knapsack;

public class Client2 {

    private static int knapsack(int W, int[] v, int[] w) {
//       return 0;
        int n = v.length;
        int[][] memo = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                memo[i][j] = -1;
            }
        }

//        for (int i = 0; i <= n; i++) {
//            Arrays.fill(memo[i], -1);
//        }

        return helper(W, v, w, v.length, memo);
    }

    private static int helper(int W, int[] v, int[] w, int n, int[][] memo) {
        // base case
        if (n == 0 || W == 0) return 0;

        // memo case
        if (memo[n][W] != -1) return memo[n][W];

        // limit case too heavy -> skip
        if (w[n - 1] > W) {
            memo[n][W] = helper(W, v, w, n - 1, memo);
            return memo[n][W];
        }

        memo[n][W] = Math.max(
                helper(W, v, w, n - 1, memo),
                v[n - 1] + helper(W - w[n - 1], v, w, n - 1, memo)
        );
        return memo[n][W];
    }


    public static void main(String[] args) {
        int W = 10;
        int[] v = {1, 4, 8, 5};
        int[] w = {3, 3, 5, 6};
        System.out.println(knapsack(W, v, w)); // 12
//        Pick:
//        item with w=3, v=4
//        item with w=5, v=8
//        Total:
//        weight = 8 ≤ 10
//        value = 12

        W = 7;
        v = new int[]{2, 2, 4, 5, 3};
        w = new int[]{3, 1, 3, 4, 2};
        System.out.println(knapsack(W, v, w)); // 10
//        Weight = 4 + 1 + 2 = 7
//        Value = 5 + 2 + 3 = 10
    }
}
