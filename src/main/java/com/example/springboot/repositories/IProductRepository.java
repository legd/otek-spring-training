package com.example.springboot.repositories;

import com.example.springboot.dbmodels.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
}
