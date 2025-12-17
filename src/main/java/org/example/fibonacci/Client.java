package org.example.fibonacci;

import java.util.Arrays;

public class Client {

    public static void main(String[] args) {
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(10));
        System.out.println(fib(30));
    }

    public static int fib(int n) {
//        return 0;
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return helper(n, memo);
    }

    private static int helper(int n, int[] memo){
        //base case
        if(n<=1) return n;

        // memo case
        if(memo[n] != -1) return memo[n];

        // recursive case
        memo[n] =  helper(n-1,memo) + helper(n-2,memo);
        return  memo[n];
    }
}
