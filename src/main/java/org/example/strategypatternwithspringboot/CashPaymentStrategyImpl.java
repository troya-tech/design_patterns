package org.example.strategypatternwithspringboot;

import org.springframework.stereotype.Component;

@Component
public class CashPaymentStrategyImpl implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("fee paid by Cash.");
    }
}




