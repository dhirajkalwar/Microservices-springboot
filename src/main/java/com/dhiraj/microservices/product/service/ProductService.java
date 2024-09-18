package com.dhiraj.microservices.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dhiraj.microservices.product.dto.ProductRequest;
import com.dhiraj.microservices.product.dto.ProductResponse;
import com.dhiraj.microservices.product.model.Product;
import com.dhiraj.microservices.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
            .name(productRequest.name())
            .description(productRequest.description())
            .price(productRequest.price()) // Ensure this is of type BigDecimal
            .build();
    
        productRepository.save(product);
        log.info("Product Created Successfully");
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
                .toList();
    }
}
