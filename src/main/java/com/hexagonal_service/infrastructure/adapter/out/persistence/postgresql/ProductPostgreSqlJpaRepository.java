package com.hexagonal_service.infrastructure.adapter.out.persistence.postgresql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPostgreSqlJpaRepository extends JpaRepository<ProductPostgreSqlEntity, Long> {
}
