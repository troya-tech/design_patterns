package org.example.strategypattern;

public class CardPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(){
        System.out.println("fee paid by card..");
    }
}
