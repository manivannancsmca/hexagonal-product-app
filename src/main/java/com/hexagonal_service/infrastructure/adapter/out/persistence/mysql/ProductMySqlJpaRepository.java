package com.hexagonal_service.infrastructure.adapter.out.persistence.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMySqlJpaRepository extends JpaRepository<ProductMySqlEntity, Long> {
}