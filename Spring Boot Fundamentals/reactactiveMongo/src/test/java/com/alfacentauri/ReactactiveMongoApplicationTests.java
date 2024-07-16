package com.alfacentauri;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;import org.springframework.data.repository.support.Repositories;

import com.alfacentauri.controllers.ProductController;
import com.alfacentauri.entities.Product;
import com.alfacentauri.repositories.ProductRespository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class ReactactiveMongoApplicationTests {

	@Autowired
	ProductController controller;
	
	@MockBean
	ProductRespository repository;
	
	@Test
	void testAddProduct() {
		Product product = new Product(null, "Nintendo", "2Ds Xl", "1200");
		Product savedProduct = new Product("abc123", "Nintendo", "2Ds Xl", "1200");
		
		when(repository.save(product)).thenReturn(Mono.just(savedProduct));
		
		StepVerifier.create(controller.addProduct(product))
			.assertNext(p -> {
				assertNotNull(p);
				assertNotNull(p.getId());
				assertEquals("abc123", p.getId());
			}).expectComplete().verify();
		
		verify(repository).save(product);
	}
	
	@Test
	public void testGetProducts() {
		when(repository.findAll()).thenReturn(Flux.just(
				new Product("abc123", "Nintendo", "2Ds Xl", "1200"),
				new Product("abc124", "Nintendo", "2Ds Xl", "1200"),
				new Product("abc125", "Nintendo", "2Ds Xl", "1200")
			));
		
		StepVerifier.create(controller.getProducts())
					.expectNextCount(3)
					.expectComplete().verify();
		
		verify(repository).findAll();
	}

}
