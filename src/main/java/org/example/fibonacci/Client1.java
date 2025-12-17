package org.example.fibonacci;

import java.util.Arrays;

public class Client1 {

    public static void main(String[] args) {
        // constraints: 0 <= n <= 30
        System.out.println("fib(0): " + fib(0)); // 0
        System.out.println("fib(1): " + fib(1)); // 1
        System.out.println("fib(10): " + fib(10)); //55
        System.out.println("fib(30): " + fib(30)); //832040
        // out of constraints //int overflow
        System.out.println("fib(47): " + fib(47));
    }

    public static int fib(int n) {
       int[] memo = new int[n+1];
       Arrays.fill(memo, -1);

       return helper(n, memo);
    }
    private static int helper(int n, int[] memo){

        // base n <= 1, return n
        if( n<=1) return n;

        // memo case
        if(memo[n] != -1) return memo[n];

        // recursive case
        memo[n] =  helper(n-1, memo) + helper(n-2, memo);
        return  memo[n];
    }
}
