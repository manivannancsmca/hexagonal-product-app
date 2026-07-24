package com.hexagonal_service.infrastructure.adapter.out.messaging.kafka;

import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.hexagonal_service.domain.model.Product;
import com.hexagonal_service.domain.port.outbound.ProductEventPublisherPort;

import lombok.RequiredArgsConstructor;

@Component
@Profile("kafka-outbound")
@RequiredArgsConstructor
public class ProductKafkaEventAdapter implements ProductEventPublisherPort {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void publishProductCreated(Product product) {
        kafkaTemplate.send("product.events", new ProductCreatedEvent(
                product.getId(),
                product.getName(),
                product.getQuantity(),
                product.getPrice()
        ));
    }

    public record ProductCreatedEvent(Long id, String name, Integer quantity, java.math.BigDecimal price) {}
}
