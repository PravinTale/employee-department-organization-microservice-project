package com.project.employeeservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
//Enables component scanning for interfaces that declared as a feign clients
@EnableFeignClients

@OpenAPIDefinition(
		info = @Info(
				title = " Employee Service REST API documentation",
				description = "Spring Boot REST API documentation Employee Service",
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
public class EmployeeServiceApplication {

//	@Bean
//	public RestTemplate restTemplate(){
//		return new RestTemplate();
//		}

//	@Bean
//	public WebClient webClient(){
//		return WebClient.builder().build();
//	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
