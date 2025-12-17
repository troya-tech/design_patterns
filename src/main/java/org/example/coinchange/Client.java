package org.example.coinchange;

public class Client {

    public static void main(String[] args) {
        Client solution = new Client();

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
        return 0;
    }
}
