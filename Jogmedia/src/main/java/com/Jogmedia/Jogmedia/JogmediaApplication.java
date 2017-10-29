package com.Jogmedia.Jogmedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.Jogmedia.Jogmedia.*"})
public class JogmediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JogmediaApplication.class, args);
	}
}
