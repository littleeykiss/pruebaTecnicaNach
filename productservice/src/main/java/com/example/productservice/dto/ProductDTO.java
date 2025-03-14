package com.example.productservice.dto;

import com.example.priceservice.dto.PriceDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private PriceDTO price;
}
