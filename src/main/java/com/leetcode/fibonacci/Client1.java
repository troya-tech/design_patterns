package com.leetcode.fibonacci;

public class Client1 {

    public static void main(String[] args) {
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(10));
        System.out.println(fib(30));
    }

    public static int fib(int n) {
//        return 0;
        // base case
        if(n <= 1) return n;

        // recursive
        return fib(n-1) + fib(n-2);
    }

}
