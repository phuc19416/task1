package com.example.goldprice.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.goldprice.GoldPriceApiApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = GoldPriceApiApplication.class)
@AutoConfigureMockMvc
class GoldPriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getGoldPricesByDateReturnsSeededList() throws Exception {
        mockMvc.perform(get("/api/gold-prices").param("date", "2026-07-02"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(15)))
                .andExpect(jsonPath("$[0].name").value("Vang mieng SJC"))
                .andExpect(jsonPath("$[0].brand").value("SJC"))
                .andExpect(jsonPath("$[0].buyPrice").value(80000000))
                .andExpect(jsonPath("$[0].sellPrice").value(82000000))
                .andExpect(jsonPath("$[0].currency").value("VND"))
                .andExpect(jsonPath("$[0].weightUnit").value("luong"))
                .andExpect(jsonPath("$[0].updatedAt").value("2026-07-02T00:00:00"));
    }

    @Test
    void getGoldPricesByBrandAndDateReturnsBrandHistory() throws Exception {
        mockMvc.perform(get("/api/gold-prices/sjc").param("date", "2026-07-02"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].brand").value("SJC"))
                .andExpect(jsonPath("$[1].updatedAt").value("2026-07-02T01:00:00"));
    }

    @Test
    void getGoldPricesByMissingDateReturnsNotFound() throws Exception {
        mockMvc.perform(get("/api/gold-prices").param("date", "2026-07-03"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").value("NOT_FOUND"));
    }
}
