package com.alfacentauri;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.alfacentauri.vaccine.Vaccine;
import com.alfacentauri.vaccine.VaccineProvider;
import com.alfacentauri.vaccine.VaccineService;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class VaccineApiTest {
	
	@Autowired
	VaccineProvider provider;
	
	@MockBean
	VaccineService service;
	
	@Test
	public void testVaccineProvider_reactive() {
		
		when(service.getVaccines())
		.thenReturn(Flux.just(new Vaccine("Pfizer1"), new Vaccine("J&J"), new Vaccine("SIMI")));
		
		StepVerifier.create(provider.provideVaccines())	
			.expectSubscription()
			.expectNext(new Vaccine("Pfizer1"))
			.expectNext(new Vaccine("J&J"))
			.expectNext(new Vaccine("SIMI"))
			.expectComplete()
			.verify();
	}
	
	
	
}
