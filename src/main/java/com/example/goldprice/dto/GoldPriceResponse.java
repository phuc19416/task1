package com.example.goldprice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record GoldPriceResponse(
        String name,
        String brand,
        BigDecimal buyPrice,
        BigDecimal sellPrice,
        String currency,
        String weightUnit,
        LocalDateTime updatedAt
) {
}
