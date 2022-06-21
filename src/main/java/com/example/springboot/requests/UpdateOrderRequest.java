package com.example.springboot.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateOrderRequest {

    private int id;
    private String status;
}
