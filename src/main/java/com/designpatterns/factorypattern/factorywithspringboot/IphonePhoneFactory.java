package com.designpatterns.factorypattern.factorywithspringboot;

import org.springframework.stereotype.Component;

@Component
public class IphonePhoneFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        return new Iphone("max pro");
    }
}
