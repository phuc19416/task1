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
    void getGoldPricesReturnsList() throws Exception {
        mockMvc.perform(get("/api/gold-prices"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].code").value("SJC"))
                .andExpect(jsonPath("$[0].currency").value("VND"))
                .andExpect(jsonPath("$[0].spread").value(2200000));
    }

    @Test
    void getGoldPriceByCodeReturnsDetail() throws Exception {
        mockMvc.perform(get("/api/gold-prices/doji"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("DOJI"))
                .andExpect(jsonPath("$.sell").value(76950000));
    }

    @Test
    void getGoldPriceByUnknownCodeReturnsNotFound() throws Exception {
        mockMvc.perform(get("/api/gold-prices/UNKNOWN"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").value("NOT_FOUND"));
    }
}
