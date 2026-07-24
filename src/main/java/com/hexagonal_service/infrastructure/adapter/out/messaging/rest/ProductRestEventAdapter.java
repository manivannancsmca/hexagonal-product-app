package com.hexagonal_service.infrastructure.adapter.out.messaging.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.hexagonal_service.domain.model.Product;
import com.hexagonal_service.domain.port.outbound.ProductEventPublisherPort;

@Component
@Profile("rest-outbound")
public class ProductRestEventAdapter implements ProductEventPublisherPort {

    private final RestClient restClient;

    public ProductRestEventAdapter(@Value("${external.notification.url}") String baseUrl) {
        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    @Override
    public void publishProductCreated(Product product) {
        restClient.post()
                .uri("/notifications/products")
                .body(new ProductNotificationDto(
                        product.getId(),
                        product.getName(),
                        product.getQuantity(),
                        product.getPrice()
                ))
                .retrieve()
                .toBodilessEntity();
    }

    public record ProductNotificationDto(Long id, String name, Integer quantity, java.math.BigDecimal price) {}
}
