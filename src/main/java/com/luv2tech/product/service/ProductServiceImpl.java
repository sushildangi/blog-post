package com.luv2tech.product.service;

import com.luv2tech.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ResponseEntity<?> getAllProduct() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productRepository.findAll());
    }
}
