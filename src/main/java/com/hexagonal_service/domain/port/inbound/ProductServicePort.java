package com.hexagonal_service.domain.port.inbound;

import java.util.List;

import com.hexagonal_service.domain.model.Product;

public interface ProductServicePort {
    Product createProduct(String name, Integer quantity, java.math.BigDecimal price);
    Product getProduct(Long id);
    List<Product> getAllProducts();
}