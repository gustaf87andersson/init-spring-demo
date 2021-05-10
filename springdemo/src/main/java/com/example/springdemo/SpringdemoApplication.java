package com.example.springdemo;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableSwagger2
@ComponentScan({ "com.example.controllers", "com.example.services", "com.example.aop" })
@EntityScan("com.example.entities")
@EnableJpaRepositories("com.example.repositories")
public class SpringdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdemoApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		// Returns a prepared Docket instance
		return new Docket(DocumentationType.SWAGGER_2).select().paths(regex("/api.*"))
				.apis(RequestHandlerSelectors.basePackage("com.example")).build().apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo("Students API", "Example API for Jensen students", "1.0", "Free to use",
				new springfox.documentation.service.Contact("Gustaf Andersson", "https://getitnordic.se",
						"gustaf.andersson@getitnordic.se"),
				"API License", "https://getitnordic.se", Collections.emptyList());
	}

}
