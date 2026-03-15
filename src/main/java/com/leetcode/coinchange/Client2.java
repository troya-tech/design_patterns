package com.leetcode.coinchange;

import java.util.Arrays;

// 2 ve 3 cozumunu kiyasi: https://chatgpt.com/g/g-p-693c8494a80881918a2271a1b4eb33e4-interview/c/69b488c8-7290-838b-98e7-df60c7be6eb1
// formul https://chatgpt.com/c/69b478d6-7c88-8387-9b42-a44c1340bf35
public class Client2 {

    public static void main(String[] args) {
        Client2 solution = new Client2();

        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11)); // 3
        System.out.println(solution.coinChange(new int[]{2}, 3));        // -1
        System.out.println(solution.coinChange(new int[]{1}, 0));        // 0
    }

    public int coinChange(int[] coins, int amount) {
        // memo[rem] = rem amount için min coin sayısı
        // -2: unknown (hesaplanmadı)
        // -1: impossible
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);

        return dfs(coins, amount, memo);
    }

    private int dfs(int[] coins, int rem, int[] memo) {
        // base cases
        if (rem == 0) return 0;
        if (rem < 0) return -1;

        // memo hit
        if (memo[rem] != -2) return memo[rem];

        int best = Integer.MAX_VALUE;

        // try each coin
        for (int c : coins) {
            int sub = dfs(coins, rem - c, memo);
            if (sub == -1) continue; // impossible path
            best = Math.min(best, sub + 1);
        }

        // store result
        memo[rem] = (best == Integer.MAX_VALUE) ? -1 : best;
        return memo[rem];
    }
}
