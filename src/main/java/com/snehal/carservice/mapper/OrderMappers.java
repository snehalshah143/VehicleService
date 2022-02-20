package com.snehal.carservice.mapper;

import com.snehal.carservice.model.domain.Order;
import com.snehal.carservice.model.dto.AssignmentJsonDto;
import com.snehal.carservice.model.dto.BookingJsonDto;
import com.snehal.carservice.model.dto.OrderJsonDto;
import com.snehal.carservice.model.dto.ProductJsonDto;
import com.snehal.carservice.model.dto.UserVehicleDetailJsonDto;
import com.snehal.carservice.model.persistable.AssignmentPersistable;
import com.snehal.carservice.model.persistable.OrderPersistable;
import java.util.HashSet;
import java.util.Set;

public class OrderMappers extends AbstarctMapper<OrderJsonDto, Order, OrderPersistable> {

  private static OrderMappers orderMappers = new OrderMappers();

  public static OrderMappers getOrderMappers() {
    return orderMappers;
  }

  public OrderJsonDto mapPersistableToJsonDto(OrderPersistable persistable) {
    OrderJsonDto jsonDto = new OrderJsonDto();

    BookingJsonDto bookingJsonDto = new BookingJsonDto();
    bookingJsonDto.setBookingId(persistable.getBooking().getBookingId());
    jsonDto.setBooking(bookingJsonDto);
    jsonDto.setOrderId(persistable.getOrderId());

    ProductJsonDto productJsonDto = new ProductJsonDto();
    productJsonDto.setProductId(persistable.getProduct().getProductId());
    jsonDto.setProduct(productJsonDto);

    UserVehicleDetailJsonDto userVehicleDetailJsonDto = new UserVehicleDetailJsonDto();
    userVehicleDetailJsonDto.setDetailId(persistable.getUserVehicleDetail().getId());
    userVehicleDetailJsonDto.setVehicle(
        VehicleMappers.getVehicleMappers()
            .mapPersistableToJsonDto(persistable.getUserVehicleDetail().getVehicle()));
    userVehicleDetailJsonDto.setVehicleNumber(
        persistable.getUserVehicleDetail().getVehicleNumber());
    jsonDto.setUserVehicleDetail(userVehicleDetailJsonDto);

    if (persistable.getAssignments() != null) {
      Set<AssignmentJsonDto> assignmentJsonDtoSet = new HashSet<AssignmentJsonDto>();
      for (AssignmentPersistable a : persistable.getAssignments()) {
        assignmentJsonDtoSet.add(
            AssignmentMappers.getAssignmentMappers().mapPersistableToJsonDto(a));
      }
      jsonDto.setAssignments(assignmentJsonDtoSet);
    }
    return jsonDto;
  }
}
