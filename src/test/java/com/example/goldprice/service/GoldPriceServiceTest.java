package com.example.goldprice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.example.goldprice.exception.GoldPriceNotFoundException;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class GoldPriceServiceTest {

    private final GoldPriceService goldPriceService = new GoldPriceService();

    @Test
    void getGoldPricesReturnsAvailablePrices() {
        var prices = goldPriceService.getGoldPrices();

        assertThat(prices).hasSize(3);
        assertThat(prices.getFirst().currency()).isEqualTo("VND");
        assertThat(prices.getFirst().spread()).isEqualByComparingTo(new BigDecimal("2200000"));
    }

    @Test
    void getGoldPriceByCodeIsCaseInsensitive() {
        var price = goldPriceService.getGoldPriceByCode("sjc");

        assertThat(price.code()).isEqualTo("SJC");
    }

    @Test
    void getGoldPriceByCodeThrowsExceptionWhenCodeDoesNotExist() {
        assertThatThrownBy(() -> goldPriceService.getGoldPriceByCode("UNKNOWN"))
                .isInstanceOf(GoldPriceNotFoundException.class);
    }
}
