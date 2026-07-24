package com.hexagonal_service.infrastructure.adapter.in.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hexagonal_service.domain.model.Product;
import com.hexagonal_service.infrastructure.adapter.in.rest.dto.CreateProductRequest;
import com.hexagonal_service.infrastructure.adapter.in.rest.dto.ProductResponse;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final com.hexagonal_service.domain.port.inbound.ProductServicePort productService;

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody CreateProductRequest request) {
        Product product = productService.createProduct(
                request.name(), request.quantity(), request.price());
        return ResponseEntity.status(HttpStatus.CREATED).body(mapToResponse(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(mapToResponse(productService.getProduct(id)));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAll() {
        List<ProductResponse> products = productService.getAllProducts().stream()
                .map(this::mapToResponse)
                .toList();
        return ResponseEntity.ok(products);
    }

    private ProductResponse mapToResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getQuantity(),
                product.getPrice()
        );
    }
}
