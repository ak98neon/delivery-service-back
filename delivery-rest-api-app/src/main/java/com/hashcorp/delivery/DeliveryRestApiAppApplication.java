package com.hashcorp.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.hashcorp"})
@EnableJpaRepositories(basePackages = {"com.hashcorp"})
@ComponentScan(basePackages = {"com.hashcorp"})
@SpringBootApplication
public class DeliveryRestApiAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliveryRestApiAppApplication.class, args);
	}

}
