package com.alfacentauri.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alfacentauri.entities.Product;
import com.alfacentauri.repositories.ProductRepository;

@RestController // Indica que es un controlador de rest
public class ProductRestController {
	
	@Autowired
	ProductRepository repository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductRestController.class);
	
	@RequestMapping(value = "/products/", method = RequestMethod.GET) // Ruta y metodo
	public List<Product> getProducts() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("id") int id) { // Para resivir parametrps por ruta
		LOGGER.info("Finding :" + id);
		return repository.findById(id).get();
	}
	
	
	@RequestMapping(value = "/products/", method = RequestMethod.POST)
	public Product createProduct(@Valid @RequestBody Product product) { // Para que lo tome del body de la peticion
		return repository.save(product);
	}
	
	@RequestMapping(value = "/products/", method = RequestMethod.PUT)
	public Product uptadeProduct(@Valid @RequestBody Product product) {
		return repository.save(product);
	}
	
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("id") int id) {
		repository.deleteById(id);
	}
	
}
