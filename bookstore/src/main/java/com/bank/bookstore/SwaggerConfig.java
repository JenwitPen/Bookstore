package com.bank.bookstore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket produceApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.bank.bookstore.controller")).paths(paths()).build();
	}

// Describe your apis
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Bookstore RESTful API with jwt")
				.description("This page lists all the rest apis for Bookstore RESTful API")
				.build();
	}

// Only select apis that matches the given Predicates.
	private Predicate<String> paths() {
// Match all paths except /error
		return Predicates.and(PathSelectors.any(), Predicates.not(PathSelectors.regex("/error.*")));
	}
}