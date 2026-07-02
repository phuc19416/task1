package com.example.goldprice.controller;

import com.example.goldprice.dto.GoldPriceResponse;
import com.example.goldprice.dto.HealthResponse;
import com.example.goldprice.service.GoldPriceService;
import jakarta.validation.constraints.Pattern;
import java.time.Instant;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public List<GoldPriceResponse> getGoldPrices() {
        return goldPriceService.getGoldPrices();
    }

    @GetMapping("/api/gold-prices/{code}")
    public GoldPriceResponse getGoldPriceByCode(
            @PathVariable
            @Pattern(regexp = "^[A-Za-z0-9_-]+$", message = "Ma vang khong hop le")
            String code
    ) {
        return goldPriceService.getGoldPriceByCode(code);
    }
}
