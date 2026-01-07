package com.designpatterns.strategypatternwithspringboot.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Client implements CommandLineRunner {
    
    private final PaymentContext context;
    private final PaymentStrategy cardPaymentStrategy;
    private final PaymentStrategy cashPaymentStrategy;

    @Autowired
    public Client(PaymentContext context, 
                  @Qualifier("cardPayment") PaymentStrategy cardPaymentStrategy,
                  @Qualifier("cashPayment") PaymentStrategy cashPaymentStrategy) {
        this.context = context;
        this.cardPaymentStrategy = cardPaymentStrategy;
        this.cashPaymentStrategy = cashPaymentStrategy;
    }

    @Override
    public void run(String... args) throws Exception {
        // Use the default strategy (cardPayment)
        context.pay();

        // Switch to cash payment using injected bean
        context.setStrategy(cashPaymentStrategy);
        context.pay();

        // Switch back to card payment using injected bean
        context.setStrategy(cardPaymentStrategy);
        context.pay();
    }
}
