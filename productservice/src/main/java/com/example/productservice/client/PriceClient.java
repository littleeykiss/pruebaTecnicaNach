package com.example.productservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.priceservice.dto.PriceDTO;


@FeignClient(name = "price-service", url = "http://localhost:8081/api/prices")
public interface PriceClient {
    @GetMapping("/{productId}")
    PriceDTO getPriceByProductId(@PathVariable Long productId);
}
