package com.snehal.carservice.dao;

import com.snehal.carservice.model.persistable.PaymentPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentPersistable, String> {}
