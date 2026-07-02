package com.example.goldprice.service;

import com.example.goldprice.dto.GoldPriceResponse;
import com.example.goldprice.exception.GoldPriceNotFoundException;
import com.example.goldprice.model.GoldPrice;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GoldPriceService {

    private static final String SOURCE_NAME = "mock-gold-price-source";

    private final List<GoldPrice> mockPrices = List.of(
            new GoldPrice("SJC", "Vang SJC", "VND/luong", new BigDecimal("74800000"), new BigDecimal("77000000")),
            new GoldPrice("DOJI", "Vang DOJI", "VND/luong", new BigDecimal("74750000"), new BigDecimal("76950000")),
            new GoldPrice("PNJ", "Vang PNJ", "VND/luong", new BigDecimal("74600000"), new BigDecimal("76850000"))
    );

    public List<GoldPriceResponse> getGoldPrices() {
        return mockPrices.stream()
                .map(this::toResponse)
                .toList();
    }

    public GoldPriceResponse getGoldPriceByCode(String code) {
        String normalizedCode = code.toUpperCase();

        return mockPrices.stream()
                .filter(price -> price.code().equals(normalizedCode))
                .findFirst()
                .map(this::toResponse)
                .orElseThrow(() -> new GoldPriceNotFoundException(code));
    }

    private GoldPriceResponse toResponse(GoldPrice price) {
        BigDecimal spread = price.sell().subtract(price.buy());

        return new GoldPriceResponse(
                price.code(),
                price.name(),
                price.unit(),
                price.buy(),
                price.sell(),
                spread,
                "VND",
                SOURCE_NAME,
                Instant.now()
        );
    }
}
