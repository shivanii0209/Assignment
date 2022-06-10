package com.zensar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;



@Configuration
@ComponentScan("com.zensar.beans")
@PropertySource("data.properties")
public class JavaConfiguration {
/*	
@Bean
public Student student() {
	return new Student(1000,"Shiv",18);
}*/
}
