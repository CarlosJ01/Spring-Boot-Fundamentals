package com.alfacentauri;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.alfacentauri.vaccine.Vaccine;
import com.alfacentauri.vaccine.VaccineController;
import com.alfacentauri.vaccine.VaccineService;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class VaccineControllerTest {
	
	@Autowired
	VaccineController controller;
	
	@MockBean
	VaccineService service;
	
	@Test
	public void testGetVaccines() {
		when(service.getVaccines())
		.thenReturn(Flux.just(new Vaccine("Pfizer1"), new Vaccine("J&J"), new Vaccine("SIMI")));
		
		StepVerifier.create(controller.getVaccines())
			.expectNextCount(3)
			.expectComplete()
			.verify();
		
		verify(service).getVaccines();
		
	}
	
	
}
