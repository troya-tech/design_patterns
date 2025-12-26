package org.example.statepattern.stream.model;




public record Order(
        String id,
        String customerId,
        double amount,
        String status // "PAID", "PENDING", "CANCELLED"
) {}
