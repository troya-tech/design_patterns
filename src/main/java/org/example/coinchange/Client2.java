package org.example.coinchange;

import java.util.Arrays;

public class Client2 {

    public static void main(String[] args) {
        Client2 solution = new Client2();

        // Example 1
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println(solution.coinChange(coins1, amount1));
        // Expected: 3  (5 + 5 + 1)

        // Example 2
        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println(solution.coinChange(coins2, amount2));
        // Expected: -1 (cannot make 3)

        // Example 3
        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println(solution.coinChange(coins3, amount3));
        // Expected: 0
    }

    public int coinChange(int[] coins, int amount) {

        // dp[a] = minimum coins needed to make amount 'a'
        int[] dp = new int[amount + 1];

        // Fill with "infinity" (unreachable state)
        Arrays.fill(dp, amount + 1);

        // Base case: 0 coins needed to make amount 0
        dp[0] = 0;

        // Build solution bottom-up
        for (int a = 1; a <= amount; a++) {
            for (int c : coins) {
                if (a - c >= 0) {
                    dp[a] = Math.min(dp[a], 1 + dp[a - c]);
                }
            }
        }

        // If dp[amount] is still "infinity", no solution
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}
