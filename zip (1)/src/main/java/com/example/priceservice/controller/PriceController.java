package com.example.priceservice.controller;

import com.example.priceservice.model.Price;
import com.example.priceservice.service.PriceService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prices")
@RequiredArgsConstructor
public class PriceController {
    private final PriceService priceService;

    @GetMapping("/{productId}")
    public ResponseEntity<Price> getPriceByProductId(@PathVariable Long productId) {
        return ResponseEntity.ok(priceService.getPriceByProductId(productId));
    }

    @PostMapping
    public ResponseEntity<Price> assignPrice(@RequestBody Price price) {
        return ResponseEntity.ok(priceService.assignPrice(price));
    }
}
