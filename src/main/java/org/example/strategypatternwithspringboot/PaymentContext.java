package org.example.strategypatternwithspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PaymentContext {

    private PaymentStrategy strategy;

    // Constructor injection with @Qualifier to specify which strategy to use by default
    @Autowired
    public PaymentContext(@Qualifier("cardPaymentStrategyImpl") PaymentStrategy paymentStrategy){
        this.strategy = paymentStrategy;
    }

    public void pay(){
        strategy.pay();
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
}
