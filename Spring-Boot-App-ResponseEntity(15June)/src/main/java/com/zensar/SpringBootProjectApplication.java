package com.zensar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"test","com.zensar"})
public class SpringBootProjectApplication {

	public static void main(String...args ) {
	System.out.println("Ram");
		SpringApplication.run(SpringBootProjectApplication.class, args);
		System.out.println("Laxman");
		
	}
	@Bean
	public ModelMapper getModelMappper() {
		return new ModelMapper();
	}



}
