package org.example.firstUniqueChar;

public class Client {

    public static void main(String[] args) {

        System.out.println(firstUniqueChar("looa"));
    }

    public static int firstUniqueChar(String s){
//        return 0;
        int[] freq = new int[256];

        for(int i = 0;i<s.length();i++){
            freq[s.charAt(i)]++;
        }

        for(int i = 0;i<s.length();i++){
            if(freq[s.charAt(i)] ==1) return i;
        }

        return -1;
    }
}
