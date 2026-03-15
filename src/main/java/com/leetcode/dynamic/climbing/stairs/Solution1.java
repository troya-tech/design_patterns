package com.leetcode.dynamic.climbing.stairs;

// link https://chatgpt.com/g/g-p-69b6f2f058c48191b499a1451ffb687a/c/69b6be04-6dc0-8385-8246-110119a9fd0a

class Solution1 {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        System.out.println(solution.climbStairs(0)); // 1
        System.out.println(solution.climbStairs(1)); // 1
        System.out.println(solution.climbStairs(2)); // 2
        System.out.println(solution.climbStairs(3)); // 3
        System.out.println(solution.climbStairs(4)); // 5
        System.out.println(solution.climbStairs(5)); // 8
    }

    public int climbStairs(int n) {
        return helper(n);
    }

    private int helper(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;

        return helper(n - 1) + helper(n - 2);
    }
}
