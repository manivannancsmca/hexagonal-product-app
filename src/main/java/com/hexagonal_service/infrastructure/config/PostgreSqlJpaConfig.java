package com.hexagonal_service.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Configuration
@Profile("postgresql")
@EnableJpaRepositories(basePackages = "com.example.product.infrastructure.adapter.out.persistence.postgresql")
@EntityScan(basePackages = "com.example.product.infrastructure.adapter.out.persistence.postgresql")
public class PostgreSqlJpaConfig {
}
