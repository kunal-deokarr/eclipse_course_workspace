package com.jpa.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring boot Documentation",
				description = "Demo project for spring boot documention api",
				version = "v1.0.0",
				contact = @Contact(
						name = "Kunal Deokar",
						email = "kunal@gmail.com",
						url = "https://www.google.com/"
						),
				license = @License(
						name = "Kuch bhi 2.0",
						url = "https://www.google.co.in/"
						)
				)
		
		)
public class DeleteSpringBootTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeleteSpringBootTestApplication.class, args);
	}

}
