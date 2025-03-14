package com.example.productservice.service;

import com.example.priceservice.dto.PriceDTO;
import com.example.productservice.client.PriceClient;
import com.example.productservice.dto.ProductDTO;
import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final PriceClient priceClient;

       public ProductDTO getProductWithPrice(Long id) {
        Product product = getProductById(id);
        PriceDTO price = priceClient.getPriceByProductId(id);
        return new ProductDTO(product.getId(), product.getName(), product.getDescription(), price);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = getProductById(id);
        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
