package com.alfacentauri.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Explica a spring en que paquete estaran los beans, la autoconfiguracion de
						// las dependencias y el escaneo de beans
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}
