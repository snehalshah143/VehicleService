package com.snehal.carservice.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snehal.carservice.admin.constants.AdminConstants;
import com.snehal.carservice.admin.service.ProductManagement;
import com.snehal.carservice.common.model.Booking;
import com.snehal.carservice.common.model.Order;
import com.snehal.carservice.user.dao.BookingRepository;
import com.snehal.carservice.user.dao.OrderRepository;
import com.snehal.carservice.user.dao.UserVehicleDetailRepository;

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
		return bookingRepository.saveAndFlush(booking);
	}
	
	public Order saveOrder(Order order){
		return orderRepository.save(order);
	}
	

	
	public List<Order> getOrders(List<Long> orderIds) {
		return orderRepository.findAllById(orderIds);
	}
	
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}
	
	public List<Order> saveOrders(List<Order> orders){
		return orderRepository.saveAllAndFlush(orders);
	}

	private double calculateFinalAmount(Booking booking){
		double finalAmount=0.0;
		for(Order order: booking.getProductCart() ){
			
//			finalAmount=finalAmount+ProductManagement.getPriceForProduct(order.getProduct());
		}
		finalAmount=finalAmount*ProductManagement.getTax();
		return finalAmount;
	}

	@Override
	public void updateOrderStatusToAssigned(List<Order> allorders) {
		List<Order> updatedOrderWithStatusList=new ArrayList();
		for(Order o:allorders) {
		o.setOrderStatus(AdminConstants.ASSIGNED);
		updatedOrderWithStatusList.add(o);
		}
		saveOrders(updatedOrderWithStatusList);
	}


}
