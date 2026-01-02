package com.designpatterns.singleton;

public class Singleton4 {

    private Singleton4() {
        System.out.println("i am created..");
    }

    private static class Holder {
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return Holder.INSTANCE;
    }

}
