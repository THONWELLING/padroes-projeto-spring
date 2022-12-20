package com.thonwelling.padroesspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * Projeto Spring Boot gerado via Spring Initializr.
 * Os seguintes módulos foram selecionados:
 * - Spring Data JPA
 * - Spring Web
 * - H2 Database
 * - OpenFeign
 *
 * @author Thonwelling
 */
@EnableFeignClients
@SpringBootApplication
public class PadroesSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadroesSpringApplication.class, args);
		System.out.println("Aplication Is Running At The http://localhost:8080 ====> ");
	}

}