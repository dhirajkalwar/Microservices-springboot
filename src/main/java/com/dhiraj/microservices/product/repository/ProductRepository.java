package com.dhiraj.microservices.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dhiraj.microservices.product.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

    String name();

    

}

