package com.example.goldprice.model;

import java.math.BigDecimal;

public record GoldPrice(
        String code,
        String name,
        String unit,
        BigDecimal buy,
        BigDecimal sell
) {
}
