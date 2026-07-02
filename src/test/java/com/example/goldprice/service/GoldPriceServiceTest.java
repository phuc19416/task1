package com.example.goldprice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.example.goldprice.GoldPriceApiApplication;
import com.example.goldprice.exception.GoldPriceNotFoundException;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = GoldPriceApiApplication.class)
class GoldPriceServiceTest {

    @Autowired
    private GoldPriceService goldPriceService;

    @Test
    void getGoldPricesReturnsSeededPricesForDate() {
        var prices = goldPriceService.getGoldPrices(LocalDate.of(2026, 7, 2));

        assertThat(prices).hasSize(15);
        assertThat(prices.getFirst().currency()).isEqualTo("VND");
        assertThat(prices.getFirst().weightUnit()).isEqualTo("luong");
        assertThat(prices.getFirst().updatedAt()).hasHour(0).hasMinute(0);
    }

    @Test
    void getGoldPricesByBrandIsCaseInsensitive() {
        var prices = goldPriceService.getGoldPricesByBrand("sjc", LocalDate.of(2026, 7, 2));

        assertThat(prices).hasSize(2);
        assertThat(prices).allMatch(price -> price.brand().equals("SJC"));
    }

    @Test
    void getGoldPricesThrowsExceptionWhenDateDoesNotExist() {
        assertThatThrownBy(() -> goldPriceService.getGoldPrices(LocalDate.of(2026, 7, 3)))
                .isInstanceOf(GoldPriceNotFoundException.class);
    }
}
