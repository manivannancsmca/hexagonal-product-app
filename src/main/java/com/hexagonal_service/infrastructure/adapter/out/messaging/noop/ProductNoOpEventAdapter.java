package com.hexagonal_service.infrastructure.adapter.out.messaging.noop;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.hexagonal_service.domain.model.Product;
import com.hexagonal_service.domain.port.outbound.ProductEventPublisherPort;

@Component
@Profile("!rest-outbound & !kafka-outbound")
public class ProductNoOpEventAdapter implements ProductEventPublisherPort {
    @Override
    public void publishProductCreated(Product product) {
        // No external notification needed
    }
}
