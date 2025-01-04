package com.example.market_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MarketServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketServiceApplication.class, args);
	}

}
