package com.example.goldprice.repository;

import com.example.goldprice.model.GoldPrice;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoldPriceRepository extends JpaRepository<GoldPrice, Long> {

    List<GoldPrice> findByUpdatedAtBetweenOrderByUpdatedAtAscBrandAsc(
            LocalDateTime start,
            LocalDateTime end
    );

    List<GoldPrice> findByBrandIgnoreCaseAndUpdatedAtBetweenOrderByUpdatedAtAsc(
            String brand,
            LocalDateTime start,
            LocalDateTime end
    );
}
