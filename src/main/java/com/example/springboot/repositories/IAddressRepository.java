package com.example.springboot.repositories;

import com.example.springboot.dbmodels.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Integer> {
}
