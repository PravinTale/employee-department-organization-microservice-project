package com.project.organizationservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = " Organisation Service REST API documentation",
				description = "Spring Boot REST API documentation Organisation Service",
				version = "v1.0",
				contact = @Contact(
						name = "Pravin Tale",
						email = "pravintale201700@gmail.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				url = "https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/"
		)



)
@SpringBootApplication
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
