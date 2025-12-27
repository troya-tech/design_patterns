package com.designpatterns.proxy;


public class Client {
    public static void main(String[] args) {

        Image image = new ImageProxy("photo.png");

        System.out.println("Image created");
        System.out.println("Calling display...");
        image.display();

        System.out.println("Calling display again...");
        image.display();
    }
}
