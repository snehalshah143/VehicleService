package com.snehal.carservice.service;

import java.util.List;

import com.snehal.carservice.model.Order;

public interface AssignmentService {

	public void createAllAssigmentsForOrders(List<Order> orders);
}
