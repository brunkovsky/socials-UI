package com.example.socials.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class UiSocialsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UiSocialsApplication.class, args);
	}

}
