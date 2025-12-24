package org.example.strategypattern;

public class CashPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(){
        System.out.println("fee paid by cash..");
    }
}
