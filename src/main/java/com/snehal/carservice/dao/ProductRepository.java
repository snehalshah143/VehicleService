package com.snehal.carservice.dao;

import com.snehal.carservice.model.persistable.ProductPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductPersistable, Long> {}
