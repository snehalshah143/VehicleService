package com.snehal.carservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snehal.carservice.model.persistable.OrderPersistable;



@Repository
public interface OrderRepository extends JpaRepository<OrderPersistable, Long> {

//List<Order> getOrderListByUserId(Long detailId);
	
}
