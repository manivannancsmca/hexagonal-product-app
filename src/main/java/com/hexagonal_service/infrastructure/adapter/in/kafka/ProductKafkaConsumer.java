package com.hexagonal_service.infrastructure.adapter.in.kafka;

import com.fasterxml.jackson.databind.JsonNode;
import com.hexagonal_service.domain.port.inbound.ProductServicePort;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Profile("kafka-inbound")
@RequiredArgsConstructor
public class ProductKafkaConsumer {

    private final ProductServicePort productService;

    @KafkaListener(topics = "product.create.requests", groupId = "product-service")
    public void consumeProductCreateRequest(JsonNode message) {
        String name = message.get("name").asText();
        Integer quantity = message.get("quantity").asInt();
        BigDecimal price = new BigDecimal(message.get("price").asText());
        
        productService.createProduct(name, quantity, price);
    }
}
