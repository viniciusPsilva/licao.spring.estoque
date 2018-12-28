package com.licao.spring.estoque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = { com.licao.spring.Entidades.models.Estoque.class })
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
