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
        // mesela amout = 3 ise bizim 4 tane alan olusturmamiz lazim memoride
        // cunku sifir da bastavar. int[3], 0, 1, 2. int[4], 0,1,2,3. boylelikle dp[3] icin de deger okumasi yapalir

        // Fill with "infinity" (unreachable state)
         Arrays.fill(dp, amount+1);
//        Arrays.fill(dp, Integer.MAX_VALUE);

        // Base case dp[0] = 0
        dp[0] = 0;

        // Build solution bottom-up
        for (int a = 1; a <= amount; a++) {
            for (int c : coins) {
                if (a - c >= 0) { // if koymazsak ArrayIndexOutOfBoundsException : Index -1 out of bounds for length 12
                    // dp[a] suanki deger, 1(secme bedeli)+dp[a-c] para secildikten sonra deger
                    dp[a] = Math.min(dp[a], 1 + dp[a - c]);
                    // yani dp[a] nin suanki degeri mi daha kucuk yoksa para secmenin bir faydasi oldu mu.
                }
            }
        }

        // If dp[amount] is still "infinity", no solution
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}
