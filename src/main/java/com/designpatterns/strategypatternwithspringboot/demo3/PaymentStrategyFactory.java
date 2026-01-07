package com.designpatterns.strategypatternwithspringboot.demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
public class PaymentStrategyFactory {
    
    private final Map<String, PaymentStrategy> strategies;

    @Autowired
    public PaymentStrategyFactory(Map<String, PaymentStrategy> strategies) {
        this.strategies = strategies;
    }

    /**
     * Get a payment strategy by bean name
     * @param strategyName the bean name (e.g., "cardPaymentStrategy", "cashPaymentStrategy")
     * @return the PaymentStrategy instance
     * @throws IllegalArgumentException if strategy not found
     */
    public PaymentStrategy getStrategy(String strategyName) {
        PaymentStrategy strategy = strategies.get(strategyName);
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy not found: " + strategyName + 
                    ". Available strategies: " + strategies.keySet());
        }
        return strategy;
    }

    /**
     * Get all available payment strategies
     * @return a map of all strategies
     */
    public Map<String, PaymentStrategy> getAllStrategies() {
        return strategies;
    }

    /**
     * Get all available strategy names
     * @return a set of strategy names
     */
    public Set<String> getAvailableStrategyNames() {
        return strategies.keySet();
    }
}

