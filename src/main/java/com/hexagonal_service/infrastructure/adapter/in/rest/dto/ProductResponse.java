package com.hexagonal_service.infrastructure.adapter.in.rest.dto;

import java.math.BigDecimal;

public record ProductResponse(Long id, String name, Integer quantity, BigDecimal price) {}
