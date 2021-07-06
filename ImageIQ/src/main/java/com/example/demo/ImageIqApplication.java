package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.controllers"})
public class ImageIqApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageIqApplication.class, args);
	}

}
