package com.designpatterns.bridgev2;

public class Client {
    public static void main(String[] args) {
        Device device = new Tv();
        Remote remote = new BasicRemote(device);
        remote.power();
        System.out.println(device);
    }
}
