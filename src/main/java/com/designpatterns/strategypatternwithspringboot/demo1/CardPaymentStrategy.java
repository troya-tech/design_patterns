package com.designpatterns.strategypatternwithspringboot.demo1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("cardPayment")
public class CardPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay() {
        System.out.println("fee paid by card");
    }
}
