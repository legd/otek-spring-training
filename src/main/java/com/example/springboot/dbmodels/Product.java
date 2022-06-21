package com.example.springboot.dbmodels;

import com.example.springboot.dtos.ProductDTO;
import com.example.springboot.responses.ProductResponse;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(length=100, nullable=false, unique=false)
    private String name;

    @Column(length=10, nullable=false, unique=false)
    private Double price;

    public ProductDTO transformToDTO() {
        return ProductDTO.builder().id(this.id).name(this.name).price(this.price).build();
    }
}
