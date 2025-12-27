package com.designpatterns.factorypattern.factory;

import com.designpatterns.factorypattern.product.S8Phone;
import com.designpatterns.factorypattern.product.Phone;

public class S8PhoneFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
//        return null;
        return new S8Phone("s8");
    }
}