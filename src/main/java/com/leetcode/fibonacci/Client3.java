package com.leetcode.fibonacci;

public class Client3 {

    public static void main(String[] args) {
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(10));
        System.out.println(fib(30));

        // out of constraints // int overflow
        System.out.println("fib(47): " + fib(47));
    }

    public static int fib(int n) { // time O(n), space O(1)
        //error case

        //base case
        if (n <= 1) return n;

        // dp (tabulation)
        int[] dp = new int[n + 1];

        // 0 1 1 2 3 5 8
        dp[0] = 0; // fib(n-2)
        dp[1] = 1; // fib(n-1)
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
