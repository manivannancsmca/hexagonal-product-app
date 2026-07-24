package com.hexagonal_service.infrastructure.adapter.out.persistence.mysql;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.hexagonal_service.domain.model.Product;
import com.hexagonal_service.domain.port.outbound.ProductRepositoryPort;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Component
@Profile("mysql")
@RequiredArgsConstructor
public class ProductMySqlAdapter implements ProductRepositoryPort {

    private final ProductMySqlJpaRepository jpaRepository;

    @Override
    public Product save(Product product) {
        ProductMySqlEntity entity = toEntity(product);
        ProductMySqlEntity saved = jpaRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Product> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .toList();
    }

    private ProductMySqlEntity toEntity(Product product) {
        ProductMySqlEntity entity = new ProductMySqlEntity();
        entity.setId(product.getId());
        entity.setName(product.getName());
        entity.setQuantity(product.getQuantity());
        entity.setPrice(product.getPrice());
        return entity;
    }

    private Product toDomain(ProductMySqlEntity entity) {
        return new Product(
                entity.getId(),
                entity.getName(),
                entity.getQuantity(),
                entity.getPrice()
        );
    }
}