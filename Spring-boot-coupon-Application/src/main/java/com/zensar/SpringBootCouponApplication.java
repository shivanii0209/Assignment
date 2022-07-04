package com.zensar;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
@ComponentScan(basePackages = {"com.zensar"})
public class SpringBootCouponApplication {
	@Value("${test.myLanguage}")
	private String language;
	
	@Autowired
	private MyConfig myConfig;
	
	public static void main(String[] args) {
		System.out.println("Shivani");
		SpringApplication.run(SpringBootCouponApplication.class, args);
		System.out.println("Mane");
	}
	
	@GetMapping("/")
	public String testConfig() {
		return "Your Language is "+ language+" And Your testProperty value is "+myConfig.getTestProperty();
	}
	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}
}
