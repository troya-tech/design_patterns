package com.designpatterns.decorator;


// Decorator - Objelere dinamik olarak yeni davranış(behavior,method) eklemeyi sağlar. mesele getCost() methodu Coffee'deki ile sabit kalmaz
// her Decorator bu methodu dinamik olarak farklilastirir.
public class Client {

    public static void main(String[] args) {

        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription());
        System.out.println(coffee.getCost());

        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);

        System.out.println(coffee.getDescription());
        System.out.println(coffee.getCost());
    }
}
