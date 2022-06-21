package com.example.springboot.dbmodels;

import com.example.springboot.dbmodels.Order;
import com.example.springboot.dbmodels.Product;
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
        return new OrderProductDTO(this.id, this.order.transformToDTO(), this.product.transformToDTO(), this.quantity);
    }
}
