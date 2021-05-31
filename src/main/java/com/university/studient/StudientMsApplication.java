package com.university.studient;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudientMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudientMsApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(@Value("${spring.application.description}") String appDescription,
								 @Value("${spring.application.version}") String appVersion) {
		return new OpenAPI()
				.info(new Info().title("Studient Application REST API")
						.version(appVersion)
						.description(appDescription)
						.contact(new Contact().name("Paulo Castillo")
								.email("pcastillode@gmail.com")
								.url("http://www.paulo-castillo.com"))
						.termsOfService("http://swagger.io/terms/")
						.license(new License().name("Apache 2.0")
								.url("http://springdoc.org")));
	}
}
