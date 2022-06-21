package com.example.springboot.repositories;

import com.example.springboot.dbmodels.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Integer> {
}
