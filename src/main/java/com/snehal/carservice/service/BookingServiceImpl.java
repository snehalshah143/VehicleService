package com.snehal.carservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snehal.carservice.constants.AdminConstants;
import com.snehal.carservice.dao.BookingRepository;
import com.snehal.carservice.dao.OrderRepository;
import com.snehal.carservice.dao.UserVehicleDetailRepository;
import com.snehal.carservice.model.persistable.BookingPersistable;
import com.snehal.carservice.model.persistable.OrderPersistable;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserVehicleDetailRepository userVehicleDetailRepository;
	


	public BookingPersistable saveBooking(BookingPersistable booking){
		booking.setFinalAmount(calculateFinalAmount(booking));
		return bookingRepository.saveAndFlush(booking);
	}
	
	public BookingPersistable getBooking(Long bookingId){
	
		return bookingRepository.findById(bookingId).get();
	}
	
	public OrderPersistable saveOrder(OrderPersistable order){
		return orderRepository.save(order);
	}
	

	
	public List<OrderPersistable> getOrders(List<Long> orderIds) {
		return orderRepository.findAllById(orderIds);
	}
	
	public List<OrderPersistable> getAllOrders() {
		return orderRepository.findAll();
	}
	
	public List<OrderPersistable> saveOrders(List<OrderPersistable> orders){
		return orderRepository.saveAll(orders);
	}

	private double calculateFinalAmount(BookingPersistable booking){
		double finalAmount=0.0;
		for(OrderPersistable order: booking.getProductCart() ){
			
//			finalAmount=finalAmount+ProductManagement.getPriceForProduct(order.getProduct());
		}
		finalAmount=booking.getFinalAmount()+(booking.getFinalAmount()*ProductManagement.getTax());
		
		return finalAmount;
	}

	@Override
	public void updateOrderStatusToAssigned(List<OrderPersistable> allorders) {
		List<OrderPersistable> updatedOrderWithStatusList=new ArrayList();
		for(OrderPersistable o:allorders) {
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

}
