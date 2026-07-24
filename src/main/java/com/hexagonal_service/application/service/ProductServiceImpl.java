package com.hexagonal_service.application.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hexagonal_service.domain.model.Product;
import com.hexagonal_service.domain.port.inbound.ProductServicePort;
import com.hexagonal_service.domain.port.outbound.ProductEventPublisherPort;
import com.hexagonal_service.domain.port.outbound.ProductRepositoryPort;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductServicePort  {

    private final ProductRepositoryPort productRepository;
    private final ProductEventPublisherPort eventPublisher;

    @Override
    public Product createProduct(String name, Integer quantity, BigDecimal price) {
        Product product = new Product(null, name, quantity, price);
        Product saved = productRepository.save(product);
        eventPublisher.publishProductCreated(saved);
        return saved;
    }

    @Override
    @Transactional(readOnly = true)
    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
