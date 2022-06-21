package com.example.springboot.dtos;

import com.example.springboot.dbmodels.Address;
import com.example.springboot.dbmodels.Order;
import com.example.springboot.dbmodels.OrderProduct;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class OrderDTO {

    private int id;
    private LocalDate date;
    private String status;

    private String paymentMethod;

    private Address deliveryAddress;
    private List<OrderProductDTO> products = new ArrayList<>();

    public Order transformToEntity() {
        List<OrderProduct> orderProducts = new ArrayList<>();
        for (OrderProductDTO product : products) {
            orderProducts.add(product.transformToEntity());
        }
        return Order.builder().date(this.date).status(this.status).paymentMethod(this.paymentMethod).
                deliveryAddress(this.deliveryAddress).orderProducts(orderProducts).build();
    }
}
