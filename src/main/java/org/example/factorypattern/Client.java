package org.example.factorypattern;

public class Client {

    public static void main(String[] args){

        PhoneFactory s8PhoneFactory = new S8PhoneFactory();
        Phone s8Phone = s8PhoneFactory.createPhone();

        System.out.println(s8Phone);

    }
}
