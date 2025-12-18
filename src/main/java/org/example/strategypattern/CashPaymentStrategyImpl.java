package org.example.strategypattern;

public class CashPaymentStrategyImpl implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("fee paid by Cash.");
    }
}


