package com.example.springboot.dtos;

import com.example.springboot.dbmodels.Product;
import com.example.springboot.responses.ProductResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {

    private int id;
    private String name;
    private Double price;

    public Product transformToEntity() {
        return Product.builder().name(this.name).price(this.price).build();
    }
}
