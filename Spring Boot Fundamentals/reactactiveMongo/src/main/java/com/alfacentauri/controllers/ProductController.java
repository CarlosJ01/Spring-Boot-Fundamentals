package com.alfacentauri.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alfacentauri.entities.Product;
import com.alfacentauri.repositories.ProductRespository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRespository repository;
	
	@PostMapping
	public Mono<Product> addProduct(@RequestBody Product product) {
		return repository.save(product);
	}
	
	@GetMapping
	public Flux<Product> getProducts() {
		return repository.findAll();
	}
	
	
}
