package com.designpatterns.strategypatternwithspringboot;

import org.springframework.stereotype.Component;

@Component
public class CardPaymentStrategyImpl implements PaymentStrategy{
    @Override
    public void pay() {
        System.out.println("fee paid by Card.");
    }
}
