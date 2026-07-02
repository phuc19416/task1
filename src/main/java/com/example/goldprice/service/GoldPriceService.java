package com.example.goldprice.service;

import com.example.goldprice.dto.GoldPriceResponse;
import com.example.goldprice.exception.GoldPriceNotFoundException;
import com.example.goldprice.mapper.GoldPriceMapper;
import com.example.goldprice.repository.GoldPriceRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GoldPriceService {

    private final GoldPriceRepository goldPriceRepository;
    private final GoldPriceMapper goldPriceMapper;

    public GoldPriceService(GoldPriceRepository goldPriceRepository, GoldPriceMapper goldPriceMapper) {
        this.goldPriceRepository = goldPriceRepository;
        this.goldPriceMapper = goldPriceMapper;
    }

    public List<GoldPriceResponse> getGoldPrices(LocalDate date) {
        var prices = goldPriceRepository.findByUpdatedAtBetweenOrderByUpdatedAtAscBrandAsc(
                startOfDay(date),
                startOfNextDay(date)
        );

        if (prices.isEmpty()) {
            throw new GoldPriceNotFoundException("Khong tim thay du lieu gia vang ngay: " + date);
        }

        return prices.stream()
                .map(goldPriceMapper::toResponse)
                .toList();
    }

    public List<GoldPriceResponse> getGoldPricesByBrand(String brand, LocalDate date) {
        var prices = goldPriceRepository.findByBrandIgnoreCaseAndUpdatedAtBetweenOrderByUpdatedAtAsc(
                brand,
                startOfDay(date),
                startOfNextDay(date)
        );

        if (prices.isEmpty()) {
            throw new GoldPriceNotFoundException(
                    "Khong tim thay du lieu gia vang cho thuong hieu " + brand + " ngay: " + date
            );
        }

        return prices.stream()
                .map(goldPriceMapper::toResponse)
                .toList();
    }

    private LocalDateTime startOfDay(LocalDate date) {
        return date.atStartOfDay();
    }

    private LocalDateTime startOfNextDay(LocalDate date) {
        return date.plusDays(1).atStartOfDay();
    }
}
