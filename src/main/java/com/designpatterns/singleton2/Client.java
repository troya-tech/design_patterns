package com.designpatterns.singleton2;

public class Client {
    public static void main(String[] args) {
//        Singleton singleton = new Singleton();
        for(int i=0;i<10;i++){
            System.out.println(i);
            Singleton singleton = Singleton.getInstance();
        }
    }
}
