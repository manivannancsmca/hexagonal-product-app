package com.hexagonal_service.domain.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    private Long id;
    private String name;
    private Integer quantity;
    private BigDecimal price;

}
