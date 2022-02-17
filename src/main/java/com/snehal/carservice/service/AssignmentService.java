package com.snehal.carservice.service;

import com.snehal.carservice.model.persistable.AssignmentPersistable;
import com.snehal.carservice.model.persistable.OrderPersistable;
import java.util.List;

public interface AssignmentService {

  public void createAssigmentsForOrders(List<OrderPersistable> orders);

  public void createAssigmentsAndUpdatedStatusForOrders(List<OrderPersistable> allorders);

  public List<AssignmentPersistable> createAssigmentsAndUpdateStatusForOrder(
      OrderPersistable order);
}
