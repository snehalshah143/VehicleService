package com.snehal.carservice.admin.service;

import java.util.List;

import com.snehal.carservice.common.model.Order;

public interface AssignmentService {

	public void createAllAssigmentsForOrders(List<Order> orders);
}
