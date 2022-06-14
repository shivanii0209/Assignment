package com.zensar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.zensar"})
public class SpringBootCouponApplication {

	public static void main(String[] args) {
		System.out.println("Shivani");
		SpringApplication.run(SpringBootCouponApplication.class, args);
		System.out.println("Mane");
	}

}
