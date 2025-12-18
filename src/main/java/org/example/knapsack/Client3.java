package org.example.knapsack;

public class Client3 {

    private static int knapsack(int W, int[] v, int[] w) {
//       return 0;
        int n = v.length;

        // dp[i][j] = max value using first i items with capacity j
        int[][] dp = new int[n + 1][W + 1];

        // base case otomatik 0
        // dp[0][*] = 0
        // dp[*][0] = 0

        for (int i = 1; i <= n; i++) {
            for (int cap = 1; cap <= W; cap++) {

                // item index = i-1
                if (w[i - 1] > cap) {
                    // item sığmıyor → alma
                    dp[i][cap] = dp[i - 1][cap];
                } else {
                    // decision: al vs alma
                    dp[i][cap] = Math.max(
                            dp[i - 1][cap],                          // alma
                            v[i - 1] + dp[i - 1][cap - w[i - 1]]     // al
                    );
                }
            }
        }

        return dp[n][W];

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
