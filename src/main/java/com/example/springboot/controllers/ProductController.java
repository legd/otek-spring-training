package com.example.springboot.controllers;

import com.example.springboot.requests.CreateProductRequest;
import com.example.springboot.responses.ProductResponse;
import com.example.springboot.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@Validated
@RestController
public class ProductController {
    private final ProductService productService;

    @GetMapping("api/products/list")
    public ResponseEntity<ProductResponse> get() {
        return ResponseEntity.ok(productService.get());
    }

//    @PostMapping
//    void addProductList(@RequestBody List<ProductDTO> newProducts) {
//        for (ProductDTO product: newProducts) {
//            productsRepository.save(product.transformToEntity());
//        }
//    }

    @PostMapping("api/products/create")
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody CreateProductRequest newProduct) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(newProduct));
    }
}
