package com.example.springboot.responses;

import com.example.springboot.dtos.ProductDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductResponse {
    private ProductDTO product;
    private List<ProductDTO> products;
}
