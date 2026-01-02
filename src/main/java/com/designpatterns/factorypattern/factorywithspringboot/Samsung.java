package com.designpatterns.factorypattern.factorywithspringboot;

import org.springframework.stereotype.Component;

@Component
public class Samsung implements Phone {
    private String model;

    public Samsung() {
        // Default constructor for Spring
    }

    public Samsung(String model) {
        this.model = model;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Samsung{" +
                "model='" + model + '\'' +
                '}';
    }
}

