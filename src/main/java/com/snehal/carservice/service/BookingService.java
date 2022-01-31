package com.snehal.carservice.service;

import java.util.List;

import com.snehal.carservice.model.dto.BookingJsonDto;
import com.snehal.carservice.model.persistable.BookingPersistable;
import com.snehal.carservice.model.persistable.OrderPersistable;

public interface BookingService {
	
	public BookingPersistable saveBooking(BookingPersistable booking);
	
	public BookingPersistable getBooking(Long bookingId);
	
	public List<BookingJsonDto> getAllBookingsForUserId(Long userId);

	public OrderPersistable saveOrder(OrderPersistable order);
		
	public List<OrderPersistable> getOrders(List<Long> orderIds);
	
	public List<OrderPersistable> saveOrders(List<OrderPersistable> orders);
	
	public List<OrderPersistable> getAllOrders();

	public void updateOrderStatusToAssigned(List<OrderPersistable> allorders);

	public void updateOrderStatusToAssigned(OrderPersistable order);
	
}
