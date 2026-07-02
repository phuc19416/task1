package com.example.goldprice.dto;

import java.math.BigDecimal;
import java.time.Instant;

public record GoldPriceResponse(
        String code,
        String name,
        String unit,
        BigDecimal buy,
        BigDecimal sell,
        BigDecimal spread,
        String currency,
        String source,
        Instant updatedAt
) {
}
