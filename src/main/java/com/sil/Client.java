package com.sil;

public class Client {
    public static void main(String[] args) {

        for(int i =0;i<10;i++){
            Singleton singleton = Singleton.getInstace();
        }
    }
}
