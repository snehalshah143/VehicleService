package com.snehal.carservice.service;

import com.snehal.carservice.model.Booking;
import com.snehal.carservice.model.Order;

public interface BookingService {
	
	public Booking saveBooking(Booking booking);

	public Order saveOrder(Order order);
		
	
}
