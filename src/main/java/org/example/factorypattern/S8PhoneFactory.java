package org.example.factorypattern;

public class S8PhoneFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
//        return null;
        return new S8Phone("s8");
    }
}