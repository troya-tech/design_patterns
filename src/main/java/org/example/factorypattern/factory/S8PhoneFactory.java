package org.example.factorypattern.factory;

import org.example.factorypattern.product.Phone;
import org.example.factorypattern.product.S8Phone;

public class S8PhoneFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
//        return null;
        return new S8Phone("s8");
    }
}