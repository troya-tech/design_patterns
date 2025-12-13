package org.example.factorypattern.product;

import org.example.factorypattern.product.Phone;

public class S8Phone implements Phone {

    private String model;


    public S8Phone(String model) {
        this.model = model;
    }

    @Override
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    @Override
    public String toString() {
        return "S8Phone{" +
                "model='" + model + '\'' +
                '}';
    }
}
