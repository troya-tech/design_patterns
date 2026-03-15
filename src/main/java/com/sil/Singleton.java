package com.sil;

public class Singleton {

    private Singleton() {
        System.out.println("i am created..");
    }

    private static class Holder{
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstace() {
return Holder.INSTANCE;

    }
}
