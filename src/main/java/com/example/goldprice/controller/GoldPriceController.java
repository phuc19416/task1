package com.example.goldprice.controller;

import com.example.goldprice.dto.GoldPriceResponse;
import com.example.goldprice.dto.HealthResponse;
import com.example.goldprice.service.GoldPriceService;
import jakarta.validation.constraints.Pattern;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@CrossOrigin(origins = "*")
@RequestMapping
public class GoldPriceController {

    private final GoldPriceService goldPriceService;

    public GoldPriceController(GoldPriceService goldPriceService) {
        this.goldPriceService = goldPriceService;
    }

    @GetMapping("/health")
    public HealthResponse health() {
        return new HealthResponse("ok", "gold-price-api", Instant.now());
    }

    @GetMapping("/api/gold-prices")
    public List<GoldPriceResponse> getGoldPrices(
            @RequestParam(defaultValue = "2026-07-02")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate date
    ) {
        return goldPriceService.getGoldPrices(date);
    }

    @GetMapping("/api/gold-prices/{brand}")
    public List<GoldPriceResponse> getGoldPriceByBrand(
            @PathVariable
            @Pattern(regexp = "^[A-Za-z0-9_-]+$", message = "Thuong hieu vang khong hop le")
            String brand,
            @RequestParam(defaultValue = "2026-07-02")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate date
    ) {
        return goldPriceService.getGoldPricesByBrand(brand, date);
    }
}
