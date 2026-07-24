package com.hexagonal_service.infrastructure.adapter.in.rest.dto;

import java.math.BigDecimal;

public record CreateProductRequest(String name, Integer quantity, BigDecimal price) {}
