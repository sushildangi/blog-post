package com.luv2tech.product.controller;

import com.luv2tech.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("Products")
    public ResponseEntity<?> getAllProduct(){
        return productService.getAllProduct();
    }
}
