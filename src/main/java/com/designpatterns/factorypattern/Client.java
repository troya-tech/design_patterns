package com.designpatterns.factorypattern;

import com.designpatterns.factorypattern.factory.PhoneFactory;
import com.designpatterns.factorypattern.factory.S8PhoneFactory;
import com.designpatterns.factorypattern.product.Phone;

public class Client {

    public static void main(String[] args){

        PhoneFactory s8PhoneFactory = new S8PhoneFactory();
        Phone s8Phone = s8PhoneFactory.createPhone();

        System.out.println(s8Phone);

    }
}
