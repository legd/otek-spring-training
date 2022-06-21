package com.example.springboot.requests;

import com.example.springboot.dbmodels.Product;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@Builder
public class CreateProductRequest {
    @NotNull
    @Size(max = 50)
    private String name;

    @NotNull
    @Positive
    private Double price;

    public Product transformToEntity() {
        return Product.builder().name(this.name).price(this.price).build();
    }
}
