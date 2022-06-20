package com.zensar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class SpringBootProductApplication {

	public static void main(String[] args) {
		System.out.println("Shivani  ...");
		SpringApplication.run(SpringBootProductApplication.class, args);
		System.out.println("MAne ..");
	}
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
