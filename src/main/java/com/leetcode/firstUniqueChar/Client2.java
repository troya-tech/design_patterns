package com.leetcode.firstUniqueChar;

public class Client2 {

    public static void main(String[] args) {

        System.out.println(firstUniqueChar("looa"));
    }

    public static int firstUniqueChar(String s) {
        int[] freq = new int[256];

        // count the freq
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i)] == 1) return i;
        }
        return -1;
    }
}
