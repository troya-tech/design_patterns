package org.example.strategypattern;

public class Client {

    public static void main(String[] args) {

        PaymentContext paymentContext = new PaymentContext(new CardPaymentStrategyImpl());
        paymentContext.pay(); // gerekirse PaymentRequest object burda input olara verilebilir.

        paymentContext.setStrategy(new CashPaymentStrategyImpl());
        paymentContext.pay();

    }
}

