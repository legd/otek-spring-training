package com.example.springboot.responses;

import com.example.springboot.dtos.OrderDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderResponse {
    private OrderDTO order;
    private List<OrderDTO> orders;
}
