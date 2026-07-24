package com.hexagonal_service.infrastructure.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("kafka-outbound")
public class KafkaTopicConfig {

    @Bean
    public NewTopic productEventsTopic() {
        return new NewTopic("product.events", 1, (short) 1);
    }
}
