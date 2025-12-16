package org.example.strategypattern;

import java.util.HashMap;
import java.util.Map;

public class PaymentContext {

    private PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy paymentStrategy){
        strategy = paymentStrategy;
    }

    public void pay(){
        strategy.pay();
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
}
