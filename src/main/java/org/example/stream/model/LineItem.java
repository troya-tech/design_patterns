package org.example.stream.model;




public record LineItem(
        String orderId,
        String sku,
        int qty,
        double unitPrice
) {}
