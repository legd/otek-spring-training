package com.example.springboot.repositories;

import com.example.springboot.dbmodels.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderProductRepository extends JpaRepository<OrderProduct, Integer> {
}
