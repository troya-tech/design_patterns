package com.designpatterns.factorypattern.factorywithspringboot;

import org.springframework.stereotype.Component;

@Component
public class SamsungPhoneFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        return new Samsung("Galaxy S24");
    }
}

