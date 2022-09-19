package com.securityimpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@EnableWebMvc
public class SecuritySpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuritySpringApplication.class, args);
	}
	
	@Bean
	public RestTemplate resttemplate() {
		return new RestTemplate();
	}
//	@Bean
//	public PasswordEncoder getPass() {
//		//return NoOpPasswordEncoder.getInstance();
//		return new BCryptPasswordEncoder(10);
//	}

	
}
