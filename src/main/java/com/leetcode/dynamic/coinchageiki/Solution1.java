package com.leetcode.dynamic.coin.change2;

// link https://chatgpt.com/g/g-p-69b6f2f058c48191b499a1451ffb687a-dynamic-programming/c/69b70527-b474-838b-b581-061d64704c8c

class Solution1 {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        System.out.println(solution.change(5, new int[]{1, 2, 5})); // 4
        System.out.println(solution.change(3, new int[]{2}));       // 0
        System.out.println(solution.change(10, new int[]{10}));     // 1
    }

    public int change(int amount, int[] coins) {
        return helper(amount, coins, 0);
    }

    private int helper(int remain, int[] coins, int start) {
        // base case
        if (remain == 0) return 1;
        if (remain < 0) return 0;

        // rec case
        int ways = 0;

        for (int i = start; i < coins.length; i++) {
            ways += helper(remain - coins[i], coins, i);
        }

        return ways;
    }
}
