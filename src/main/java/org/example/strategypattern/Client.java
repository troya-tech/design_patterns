package org.example.strategypattern;



public class Client {
    public static void main(String[] args){

        PaymentContext context = new PaymentContext(new CardPaymentStrategy());
        context.pay();

        context.setStrategy(new CashPaymentStrategy());
        context.pay();
    }
}
