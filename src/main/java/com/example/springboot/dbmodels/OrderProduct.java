package com.example.springboot.dbmodels;

import com.example.springboot.dtos.OrderProductDTO;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="order_products")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    @Transient
    public Double getTotalPrice() {
        return getProduct().getPrice() * getQuantity();
    }

    public OrderProductDTO transformToDTO() {
        return OrderProductDTO.builder().id(this.id).order(this.order.transformToDTO()).product(this.product.transformToDTO()).build();
    }
}
