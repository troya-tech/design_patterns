package org.example.fibonacci;

import java.util.Arrays;

public class Client1 {

    public static void main(String[] args) {
        // constraints: 0 <= n <= 30
        System.out.println("fib(0): " + fib(0));
        System.out.println("fib(1): " + fib(1));
        System.out.println("fib(5): " + fib(5));
        System.out.println("fib(30): " + fib(30));
        // out of constraints
        System.out.println("fib(40): " + fib(40));
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
