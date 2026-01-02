package com.leetcode.stream.model;




public record LineItem(
        String orderId,
        String sku,
        int qty,
        double unitPrice
) {}
