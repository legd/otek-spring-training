package com.example.springboot.dtos;

import com.example.springboot.dbmodels.OrderProduct;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderProductDTO {

    private int id;

    private OrderDTO order;

    private ProductDTO product;

    private Integer quantity;

    public OrderProductDTO(int id, OrderDTO order, ProductDTO product, Integer quantity) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OrderProduct transformToEntity() {
        return OrderProduct.builder().order(this.order.transformToEntity()).product(this.product.transformToEntity())
                .quantity(this.quantity).build();
    }
}
