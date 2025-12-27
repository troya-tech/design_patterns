package com.designpatterns.strategypattern;

public class CardPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(){
        System.out.println("fee paid by card..");
    }
}
