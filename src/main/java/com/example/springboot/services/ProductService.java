package com.example.springboot.services;

import com.example.springboot.dbmodels.Product;
import com.example.springboot.dtos.ProductDTO;
import com.example.springboot.requests.CreateProductRequest;
import com.example.springboot.repositories.IProductRepository;
import com.example.springboot.responses.OrderResponse;
import com.example.springboot.responses.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final IProductRepository productsRepository;

    public ProductResponse get() {
        List<ProductDTO> productsToList = new ArrayList<>();
        List<Product> products = productsRepository.findAll();
        ProductResponse.ProductResponseBuilder response = ProductResponse.builder();
        for (Product product: products) {
            productsToList.add(product.transformToDTO());
        }
        return response.products(productsToList).build();
    }
    public ProductResponse create(CreateProductRequest newProductRequest) {
        Product addedProduct = productsRepository.save(newProductRequest.transformToEntity());
        ProductResponse.ProductResponseBuilder response = ProductResponse.builder();
        return response.product(addedProduct.transformToDTO()).build();
    }

}
