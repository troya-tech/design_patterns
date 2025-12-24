package org.example.strategypattern;




public class PaymentContext {
    private PaymentStrategy strategy;

    public  PaymentContext(PaymentStrategy strategy){
        this.strategy = strategy;
    }

    public void setStrategy(PaymentStrategy strategy){
        this.strategy = strategy;
    }

    public void pay(){
        this.strategy.pay();
    };
}
