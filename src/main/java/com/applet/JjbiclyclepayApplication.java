package com.applet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class JjbiclyclepayApplication {

	public static void main(String[] args) {
		SpringApplication.run(JjbiclyclepayApplication.class, args);
	}
}
