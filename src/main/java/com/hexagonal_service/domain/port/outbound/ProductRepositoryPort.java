package com.hexagonal_service.domain.port.outbound;

import java.util.List;
import java.util.Optional;

import com.hexagonal_service.domain.model.Product;

public interface ProductRepositoryPort {
    Product save(Product product);
    Optional<Product> findById(Long id);
    List<Product> findAll();
}
