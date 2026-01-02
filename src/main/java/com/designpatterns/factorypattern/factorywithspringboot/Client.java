package com.designpatterns.factorypattern.factorywithspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Client implements CommandLineRunner {

    private final PhoneFactory phoneFactory;

    @Autowired
    public Client(@Qualifier("iphonePhoneFactory") PhoneFactory phoneFactory) {
        this.phoneFactory = phoneFactory;
    }

    @Override
    public void run(String... args) throws Exception {
        Phone phone = phoneFactory.createPhone();
        System.out.println(phone);
    }
}
