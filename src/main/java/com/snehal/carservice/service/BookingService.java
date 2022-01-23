package com.snehal.carservice.service;

import java.util.List;

import com.snehal.carservice.model.Booking;
import com.snehal.carservice.model.Order;

public interface BookingService {
	
	public Booking saveBooking(Booking booking);

	public Order saveOrder(Order order);
		
	public List<Order> getOrders(List<Long> orderIds);
	
	public List<Order> saveOrders(List<Order> orders);
	
	public List<Order> getAllOrders();

	public void updateOrderStatusToAssigned(List<Order> allorders);
	
}
