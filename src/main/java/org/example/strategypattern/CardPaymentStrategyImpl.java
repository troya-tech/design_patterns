package org.example.strategypattern;

public class CardPaymentStrategyImpl implements PaymentStrategy{
    @Override
    public void pay() {
        System.out.println("fee paid by Card.");
    }
}
