package com.hexagonal_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
    "com.hexagonal_service.domain",
    "com.hexagonal_service.application",
    "com.hexagonal_service.infrastructure.adapter.in",
    "com.hexagonal_service.infrastructure.adapter.out.messaging",
    "com.hexagonal_service.infrastructure.config"
})
public class HexagonalProductAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexagonalProductAppApplication.class, args);
	}

}
