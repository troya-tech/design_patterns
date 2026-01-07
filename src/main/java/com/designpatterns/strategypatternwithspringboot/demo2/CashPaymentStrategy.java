package com.designpatterns.strategypatternwithspringboot.demo2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("cashPayment")
public class CashPaymentStrategy implements PaymentStrategy{

    @Override
    public void pay() {
        System.out.println("fee paid by cash");
    }
}

