package com.spring.deepseek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "Controller")
public class DeepseekApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeepseekApplication.class, args);
	}

}
