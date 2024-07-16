package com.alfacentauri;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.alfacentauri.vaccine.Vaccine;
import com.alfacentauri.vaccine.VaccineProvider;

import reactor.test.StepVerifier;

@SpringBootTest
public class VaccineTest {
	
	@Autowired
	VaccineProvider provider;
	
	@Test
	public void testVaccineProvider_reactive() {
		StepVerifier.create(provider.provideVaccines())	
			.expectSubscription()
			.expectNext(new Vaccine("Pfizer"))
			.expectNext(new Vaccine("J&J"))
			.expectNext(new Vaccine("SIMI"))
			.expectComplete()
			.verify();
	}
	
	@Test
	public void testVaccineProvider_reactive_assertThat() {
		StepVerifier.create(provider.provideVaccines())	
		.expectSubscription()
		.assertNext(vaccine -> {
			assertThat(vaccine.getName()).isNotNull();
			assertTrue(vaccine.isDelivered());
			assertEquals("Pfizer", vaccine.getName());
		})
//		.expectNextMatches(vaccine -> {
//			assertThat(vaccine.getName()).isNotNull();
//			assertTrue(vaccine.isDelivered());
//			assertEquals("J&J", vaccine.getName());
//			return true;
//		})
		.thenConsumeWhile(vaccine -> {
			System.out.println(vaccine.getName());
			return true;
		})
//		.expectNext(new Vaccine("J&J"))
//		.expectNext(new Vaccine("SIMI"))
		.expectComplete()
		.verify();
	}
	
	
	
	@Test
	public void testVaccineProvider_reactive_expectNextCount() {
		StepVerifier.create(provider.provideVaccines())	
		.expectSubscription()
		.expectNextCount(3)
		.expectComplete()
		.verify();
	}
	
}
