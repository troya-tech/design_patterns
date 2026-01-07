package com.designpatterns.strategypatternwithspringboot.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PaymentContext {

    private PaymentStrategy strategy;

    @Autowired
    public PaymentContext(@Qualifier("cardPayment") PaymentStrategy strategy){
        this.strategy = strategy;
    }

   public void setStrategy(PaymentStrategy strategy){
        this.strategy = strategy;
   }

   public void pay(){
        strategy.pay();
   }
}
