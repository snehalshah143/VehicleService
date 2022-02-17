package com.snehal.carservice.service;

import com.snehal.carservice.common.util.DateTimeUtil;
import com.snehal.carservice.constants.AdminConstants;
import com.snehal.carservice.dao.AppUserRepository;
import com.snehal.carservice.dao.BookingRepository;
import com.snehal.carservice.dao.OrderRepository;
import com.snehal.carservice.dao.UserVehicleDetailRepository;
import com.snehal.carservice.mapper.BookingMappers;
import com.snehal.carservice.model.dto.BookingJsonDto;
import com.snehal.carservice.model.persistable.BookingPersistable;
import com.snehal.carservice.model.persistable.OrderPersistable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

  @Autowired private BookingRepository bookingRepository;

  @Autowired private OrderRepository orderRepository;

  @Autowired private UserVehicleDetailRepository userVehicleDetailRepository;

  @Autowired private AppUserRepository appUserRepository;

  public BookingPersistable saveBooking(BookingPersistable booking) {
    booking.setFinalAmount(calculateFinalAmount(booking));
    booking.setCreatedOn(DateTimeUtil.getCurrentDate());
    booking.setCreatedBy("USER");
    booking.setRecordStatus("Active");
    return bookingRepository.saveAndFlush(booking);
  }

  public BookingPersistable getBooking(Long bookingId) {

    return bookingRepository.findById(bookingId).get();
  }

  public OrderPersistable saveOrder(OrderPersistable order) {
    return orderRepository.save(order);
  }

  public List<OrderPersistable> getOrders(List<Long> orderIds) {
    return orderRepository.findAllById(orderIds);
  }

  public List<OrderPersistable> getAllOrders() {
    return orderRepository.findAll();
  }

  public List<OrderPersistable> saveOrders(List<OrderPersistable> orders) {
    return orderRepository.saveAll(orders);
  }

  private double calculateFinalAmount(BookingPersistable booking) {
    double finalAmount = 0.0;
    for (OrderPersistable order : booking.getProductCart()) {

      //			finalAmount=finalAmount+ProductManagement.getPriceForProduct(order.getProduct());
    }
    finalAmount =
        booking.getFinalAmount() + (booking.getFinalAmount() * ProductManagement.getTax());

    return finalAmount;
  }

  @Override
  public void updateOrderStatusToAssigned(List<OrderPersistable> allorders) {
    List<OrderPersistable> updatedOrderWithStatusList = new ArrayList();
    for (OrderPersistable o : allorders) {
      o.setOrderStatus(AdminConstants.ASSIGNED);
      updatedOrderWithStatusList.add(o);
    }
    saveOrders(updatedOrderWithStatusList);
  }

  @Override
  public void updateOrderStatusToAssigned(OrderPersistable order) {

    order.setOrderStatus(AdminConstants.ASSIGNED);
    saveOrder(order);
  }

  @Override
  public List<BookingJsonDto> getAllBookingsForUserId(Long userId) {
    // TODO Auto-generated method stub
    List<BookingPersistable> bookings = appUserRepository.findById(userId).get().getBookings();

    List<BookingJsonDto> bookingsJsonDtoList =
        bookings.stream()
            .map(b -> BookingMappers.getBookingMappers().mapPersistableToJsonDto(b))
            .collect(Collectors.toList());
    return bookingsJsonDtoList;
  }
}
