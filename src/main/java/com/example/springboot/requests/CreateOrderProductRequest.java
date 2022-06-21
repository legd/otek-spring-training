package com.example.springboot.requests;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class CreateOrderProductRequest {

    @NotNull
    private Integer productId;

    @NotNull
    private Integer quantity;
}
