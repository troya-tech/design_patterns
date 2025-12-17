package org.example.knapsack;

public class Client1 {

    private static int knapsack(int W, int[] v, int[] w) {
//       return 0;
        return helper1(W,  v,  w, w.length);
    }

    private static int helper1(int W, int[] v, int[] w, int n){
        // base case
        if (n<=0 || W <=0) return 0;

        // limit case // pointer move next
        if(w[n-1] > W) return helper1(W, v, w, n-1);

        // recursive - decision case
        return Math.max(
                helper1(W, v, w, n-1), // exclude decision
                v[n-1] + helper1(W - w[n - 1],v, w, n-1) // include decision
        );
    }

    public static void main(String[] args) {
        int W = 10;
        int[] v = {1, 4, 8, 5};
        int[] w = {3, 3, 5, 6};
        System.out.println(knapsack(W, v, w)); // 12
//        Pick:
//        item with w=3, v=4
//        item with w=5, v=8
//        Total:
//        weight = 8 ≤ 10
//        value = 12

        W = 7;
        v = new int[]{2, 2, 4, 5, 3};
        w = new int[]{3, 1, 3, 4, 2};
        System.out.println(knapsack(W, v, w)); // 10
//        Weight = 4 + 1 + 2 = 7
//        Value = 5 + 2 + 3 = 10
    }
}
