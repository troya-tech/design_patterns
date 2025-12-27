package com.designpatterns.statepattern.stream.model;




public record LineItem(
        String orderId,
        String sku,
        int qty,
        double unitPrice
) {}
