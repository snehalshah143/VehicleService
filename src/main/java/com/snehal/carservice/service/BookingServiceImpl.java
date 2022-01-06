package com.snehal.carservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snehal.carservice.model.Booking;
import com.snehal.carservice.model.Order;
import com.snehal.carservice.registration.BookingRepository;
import com.snehal.carservice.registration.OrderRepository;
import com.snehal.carservice.registration.UserVehicleDetailRepository;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserVehicleDetailRepository userVehicleDetailRepository;
	


	public Booking saveBooking(Booking booking){
		booking.setFinalAmount(calculateFinalAmount(booking));
		return bookingRepository.save(booking);
	}
	
	public Order saveOrder(Order order){
		return orderRepository.save(order);
	}

	private double calculateFinalAmount(Booking booking){
		double finalAmount=0.0;
		for(Order order: booking.getProductCart() ){
			
//			finalAmount=finalAmount+ProductManagement.getPriceForProduct(order.getProduct());
		}
		finalAmount=finalAmount*ProductManagement.getTax();
		return finalAmount;
	}


}
