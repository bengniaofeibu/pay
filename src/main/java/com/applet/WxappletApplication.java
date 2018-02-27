package com.applet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WxappletApplication {

	public static void main(String[] args) {
		SpringApplication.run(WxappletApplication.class, args);
	}
}
