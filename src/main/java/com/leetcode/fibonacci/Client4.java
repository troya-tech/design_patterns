package com.leetcode.fibonacci;

public class Client4 {

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
        if(n<=1) return n;

        // bottom up
        // 0 1 1 2 3 5 8
        int l = 0; // fib(n-2)
        int r = 1; // fib(n-1)
        for(int i = 2; i<n+1;i++){
            int cur = l + r; // compute
            l = r;
            r = cur;
        }
        return r;
    }
}
