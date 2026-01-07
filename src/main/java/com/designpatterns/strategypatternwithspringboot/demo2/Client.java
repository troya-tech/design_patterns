package com.designpatterns.strategypatternwithspringboot.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Client implements CommandLineRunner {
    
    private final PaymentContext context;
    private final Map<String, PaymentStrategy> strategies;

    @Autowired
    public Client(PaymentContext context, Map<String, PaymentStrategy> strategies) {
        this.context = context;
        this.strategies = strategies;
    }

    @Override
    public void run(String... args) throws Exception {
        // Use the default strategy (cardPayment)
        context.pay();

        // Switch to cash payment using injected map
        // Spring automatically collects all PaymentStrategy beans into the map
        // Key is the bean name (class name with first letter lowercase)
        context.setStrategy(strategies.get("cashPaymentStrategy"));
        context.pay();

        // Switch back to card payment using injected map
        context.setStrategy(strategies.get("cardPaymentStrategy"));
        context.pay();
    }
}
