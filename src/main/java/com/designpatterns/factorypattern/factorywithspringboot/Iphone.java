package com.designpatterns.factorypattern.factorywithspringboot;

import org.springframework.stereotype.Component;

@Component
public class Iphone implements Phone{
    private String model;

    public Iphone() {
        // Default constructor for Spring
    }

    public Iphone(String model) {
        this.model = model;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Iphone{" +
                "model='" + model + '\'' +
                '}';
    }
}
