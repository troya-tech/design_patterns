package org.example.singleton2;

public class Singleton {

    private static Singleton instance;

    private Singleton() {
        System.out.println("ben olusuyorum.");
    }

    public static Singleton getInstance() {

        // one thread lazy loading
        if (instance == null) {
            instance = new Singleton();
        }

        // multi thread lazy loading
        if (instance == null) { // null check to prevent unnecassary synchronized
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
