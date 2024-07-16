package com.alfacentauri.core;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.alfacentauri.core.services.PaymentServiceImpl;


@SpringBootTest //Es una clase de testeo
class CoreApplicationTests {
	
	@Autowired
	PaymentServiceImpl service;
	
	@Test // Es una funcion de esteo
	void testDependecyInjection() {
		assertNotNull(service); // Si creo el service solo con la injeccion de dependencias
		assertNotNull(service.getDao());
	}

}
