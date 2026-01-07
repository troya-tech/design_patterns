package com.designpatterns.strategypatternwithspringboot.demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Client implements CommandLineRunner {
    
    private final PaymentContext context;
    private final PaymentStrategyFactory strategyFactory;

    @Autowired
    public Client(PaymentContext context, PaymentStrategyFactory strategyFactory) {
        this.context = context;
        this.strategyFactory = strategyFactory;
    }

    @Override
    public void run(String... args) throws Exception {
        // Use the default strategy (cardPayment)
        context.pay();

        // Switch to cash payment using factory
        context.setStrategy(strategyFactory.getStrategy("cashPaymentStrategy"));
        context.pay();

        // Switch back to card payment using factory
        context.setStrategy(strategyFactory.getStrategy("cardPaymentStrategy"));
        context.pay();
    }
}
