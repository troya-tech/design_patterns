package org.example.factorypattern;

import org.example.factorypattern.factory.PhoneFactory;
import org.example.factorypattern.factory.S8PhoneFactory;
import org.example.factorypattern.product.Phone;

public class Client {

    public static void main(String[] args){

        PhoneFactory s8PhoneFactory = new S8PhoneFactory();
        Phone s8Phone = s8PhoneFactory.createPhone();

        System.out.println(s8Phone);

    }
}
