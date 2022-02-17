package com.snehal.carservice.dao;

import com.snehal.carservice.model.persistable.OrderPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderPersistable, Long> {

  // List<Order> getOrderListByUserId(Long detailId);

}
