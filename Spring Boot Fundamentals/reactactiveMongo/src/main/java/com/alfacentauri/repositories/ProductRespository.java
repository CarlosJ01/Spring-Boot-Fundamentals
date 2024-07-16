package com.alfacentauri.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.alfacentauri.entities.Product;

public interface ProductRespository extends ReactiveMongoRepository<Product, String>{
}
