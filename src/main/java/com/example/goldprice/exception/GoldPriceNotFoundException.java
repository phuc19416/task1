package com.example.goldprice.exception;

public class GoldPriceNotFoundException extends RuntimeException {

    public GoldPriceNotFoundException(String code) {
        super("Khong tim thay gia vang voi ma: " + code);
    }
}
