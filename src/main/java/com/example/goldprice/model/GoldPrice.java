package com.example.goldprice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "gold_prices")
public class GoldPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false, precision = 15, scale = 0)
    private BigDecimal buyPrice;

    @Column(nullable = false, precision = 15, scale = 0)
    private BigDecimal sellPrice;

    @Column(nullable = false, length = 10)
    private String currency;

    @Column(nullable = false, length = 30)
    private String weightUnit;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    protected GoldPrice() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
