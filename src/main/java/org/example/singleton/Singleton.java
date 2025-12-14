package org.example.singleton;

public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton(){
        System.out.println("ben olusuyorum.");
    }

    public static Singleton getInstance(){
        return instance;
    }
}
