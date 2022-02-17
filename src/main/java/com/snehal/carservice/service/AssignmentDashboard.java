package com.snehal.carservice.service;

import com.snehal.carservice.common.ProductType;
import com.snehal.carservice.common.util.DateTimeUtil;
import com.snehal.carservice.constants.AssignmentStatus;
import com.snehal.carservice.model.persistable.AssignmentPersistable;
import com.snehal.carservice.model.persistable.OrderPersistable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AssignmentDashboard {

  public static List<AssignmentPersistable> createAllAssignments(List<OrderPersistable> allorders) {
    List<AssignmentPersistable> allAssignments = new ArrayList<AssignmentPersistable>();

    for (OrderPersistable o : allorders) {
      createAssignmentForOrder(allAssignments, o);
    }
    return allAssignments;
  }

  public static List<AssignmentPersistable> createAssignmentForOrder(OrderPersistable order) {
    List<AssignmentPersistable> allAssignments = new ArrayList<AssignmentPersistable>();

    createAssignmentForOrder(allAssignments, order);

    return allAssignments;
  }

  private static void createAssignmentForOrder(
      List<AssignmentPersistable> allAssignments, OrderPersistable o) {
    ProductType productType = o.getProduct().getProductType();
    switch (productType) {
      case DAILY_WASH:
        createDailyWashAssignments(o, allAssignments);
        break;
      case ALTERNATE_WASH:
        createAlternateWashAssignments(o, allAssignments);
        break;
      case ON_DEMAND_WASH:
        createOnDemandWashAssignments(o, allAssignments);
        break;
    }
  }

  private static void createDailyWashAssignments(
      OrderPersistable o, List<AssignmentPersistable> allAssignments) {

    int count = 24;

    // should be run before 12 pm on indian server
    Calendar c = Calendar.getInstance();
    c.add(Calendar.DATE, 1);
    while (count > 0) {

      if (!(c.get(Calendar.DAY_OF_WEEK) == 1)) {
        AssignmentPersistable a = new AssignmentPersistable();
        a.setPriority(0);
        a.setAssignmentStatus(AssignmentStatus.NOT_STARTED.name());
        a.setOrder(o);
        a.setAssignmentDate(new java.sql.Date(c.getTimeInMillis()));
        a.setCreatedBy("ADMIN");
        a.setCreatedOn(DateTimeUtil.getCurrentDate());
        a.setRecordStatus("Active");
        allAssignments.add(a);
        count--;
      }
      c.add(Calendar.DATE, 1);
    }
  }

  private static void createAlternateWashAssignments(
      OrderPersistable o, List<AssignmentPersistable> allAssignments) {

    int count = 12;

    // should be run before 12 pm on indian server
    Calendar c = Calendar.getInstance();
    c.add(Calendar.DATE, 1);
    while (count > 0) {

      if (!(c.get(Calendar.DAY_OF_WEEK) == 1)) {
        AssignmentPersistable a = new AssignmentPersistable();
        a.setPriority(0);
        a.setAssignmentStatus(AssignmentStatus.NOT_STARTED.name());
        a.setOrder(o);
        a.setAssignmentDate(new java.sql.Date(c.getTimeInMillis()));
        a.setCreatedBy("ADMIN");
        a.setCreatedOn(DateTimeUtil.getCurrentDate());
        a.setRecordStatus("Active");
        allAssignments.add(a);
        count--;
      }
      c.add(Calendar.DATE, c.get(Calendar.DAY_OF_WEEK) == 1 ? 1 : 2);
    }
  }

  private static void createOnDemandWashAssignments(
      OrderPersistable o, List<AssignmentPersistable> allAssignments) {

    // should be run before 12 pm on indian server
    Calendar c = Calendar.getInstance();

    if (c.get(Calendar.DAY_OF_WEEK) == 1) {
      c.add(Calendar.DATE, 1);
    }
    AssignmentPersistable a = new AssignmentPersistable();
    a.setPriority(4);
    a.setAssignmentStatus(AssignmentStatus.NOT_STARTED.name());
    a.setOrder(o);
    a.setAssignmentDate(new java.sql.Date(c.getTimeInMillis()));
    a.setCreatedBy("ADMIN");
    a.setCreatedOn(DateTimeUtil.getCurrentDate());
    a.setRecordStatus("Active");
    allAssignments.add(a);
  }
}
