package com.snehal.carservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snehal.carservice.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
