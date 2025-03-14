package com.example.priceservice.service;

import com.example.priceservice.model.Price;
import com.example.priceservice.repository.PriceRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PriceService {
    private final PriceRepository priceRepository;

    public Price getPriceByProductId(Long productId) {
        return priceRepository.findByProductId(productId)
                .orElseThrow(() -> new RuntimeException("Precio no encontrado"));
    }

    public Price assignPrice(Price price) {
        return priceRepository.save(price);
    }
}
