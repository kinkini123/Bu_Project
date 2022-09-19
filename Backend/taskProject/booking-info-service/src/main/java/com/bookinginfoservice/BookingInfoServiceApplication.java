package com.bookinginfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableWebMvc
@EnableEurekaClient
public class BookingInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingInfoServiceApplication.class, args);
	}
	@Bean
	public RestTemplate resttemplate() {
		return new RestTemplate();
	}
	

}
