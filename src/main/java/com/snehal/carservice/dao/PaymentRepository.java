package com.snehal.carservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snehal.carservice.model.persistable.PaymentPersistable;
@Repository
public interface PaymentRepository extends JpaRepository<PaymentPersistable, String> {

}
