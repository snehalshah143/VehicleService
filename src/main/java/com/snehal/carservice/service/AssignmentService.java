package com.snehal.carservice.service;

import java.util.List;

import com.snehal.carservice.model.persistable.OrderPersistable;

public interface AssignmentService {

	public void createAssigmentsForOrders(List<OrderPersistable> orders);

	public void createAssigmentsAndUpdatedStatusForOrders(List<OrderPersistable> allorders);
}
