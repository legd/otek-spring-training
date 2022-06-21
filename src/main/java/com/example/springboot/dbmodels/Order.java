package com.example.springboot.dbmodels;

import com.example.springboot.dtos.OrderDTO;
import com.example.springboot.dtos.OrderProductDTO;
import com.example.springboot.responses.OrderResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    private String status;

    private String paymentMethod;

    @OneToOne
    private Address deliveryAddress;

    @OneToMany
    private List<OrderProduct> orderProducts = new ArrayList<>();


    @Transient
    public Double getAmount() {
        double sum = 0D;
        List<OrderProduct> orderProducts = getOrderProducts();
        for (OrderProduct product : orderProducts) {
            sum += product.getTotalPrice();
        }
        return sum;
    }

    @Transient
    public int getTotalOffProducts() {
        return this.orderProducts.size();
    }

    public OrderDTO transformToDTO() {
        List<OrderProductDTO> orderProductDTOS = new ArrayList<>();
        for (OrderProduct product : orderProducts) {
            orderProductDTOS.add(product.transformToDTO());
        }

        return OrderDTO.builder().id(this.id).date(this.date).status(this.status).paymentMethod(this.paymentMethod)
                .deliveryAddress(this.deliveryAddress).products(orderProductDTOS).build();
    }
}
