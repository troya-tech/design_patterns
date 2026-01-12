package com.designpatterns.singleton;


// one thread lazy loading singleton
public class Singleton2 {
    private static Singleton2 instance = new Singleton2();

    private Singleton2(){
        System.out.println("i am created..");
    }

    public static Singleton2 getInstance(){
        return instance;
    }
}
