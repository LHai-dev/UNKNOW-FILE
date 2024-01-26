package com.carbone;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarboneApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(CarboneApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello bong");
	}
}
