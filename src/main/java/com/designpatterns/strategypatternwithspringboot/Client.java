package com.designpatterns.strategypatternwithspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Client implements CommandLineRunner {

    private final PaymentContext paymentContext;
    private final CardPaymentStrategyImpl cardPaymentStrategy;
    private final CashPaymentStrategyImpl cashPaymentStrategy;

    // Constructor injection - Spring will inject all dependencies
    @Autowired
    public Client(PaymentContext paymentContext, 
                  CardPaymentStrategyImpl cardPaymentStrategy,
                  CashPaymentStrategyImpl cashPaymentStrategy) {
        this.paymentContext = paymentContext;
        this.cardPaymentStrategy = cardPaymentStrategy;
        this.cashPaymentStrategy = cashPaymentStrategy;
    }

    @Override
    public void run(String... args) throws Exception {
        // Use the injected PaymentContext (defaults to CardPaymentStrategy)
        paymentContext.pay(); // Will use CardPaymentStrategy (as specified in PaymentContext constructor)

        // Change strategy dynamically
        paymentContext.setStrategy(cardPaymentStrategy);
        paymentContext.pay();

        paymentContext.setStrategy(cashPaymentStrategy);
        paymentContext.pay();
    }
}

