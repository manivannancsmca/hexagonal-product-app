package com.hexagonal_service.domain.port.outbound;

import com.hexagonal_service.domain.model.Product;

public interface ProductEventPublisherPort {
    void publishProductCreated(Product product);
}

