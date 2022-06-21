package com.example.springboot.requests;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
public class CreateOrderRequest {

    @NotNull
    private String paymentMethod;

    @NotNull
    private Integer deliveryAddress;

    @NotNull
    private List<CreateOrderProductRequest> orderProducts;
}
