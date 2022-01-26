package com.snehal.carservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snehal.carservice.dao.AssignmentRepository;
import com.snehal.carservice.model.persistable.AssignmentPersistable;
import com.snehal.carservice.model.persistable.OrderPersistable;

@Service
public class AssignmentServiceImpl implements AssignmentService{

	@Autowired
	private BookingService bookingService;
	@Autowired
	private AssignmentRepository assignmentRepository;
	
	
	public void saveALLAssignments(List<AssignmentPersistable> assignments) {
		assignmentRepository.saveAll(assignments);
	}
	
	public void createAssigmentsForOrders(List<OrderPersistable> orders) {
		
		List<AssignmentPersistable> allAssignments=AssignmentDashboard.createAllAssignments(orders);
		saveALLAssignments(allAssignments);
		
	}
	
	
	public void createAssigmentsAndUpdatedStatusForOrders(List<OrderPersistable> orders) {
		
		createAssigmentsForOrders(orders);
		bookingService.updateOrderStatusToAssigned(orders);
		
	}
	
	public List<AssignmentPersistable> createAssigmentsAndUpdateStatusForOrder(OrderPersistable order) {
		
		List<AssignmentPersistable> allAssignments=AssignmentDashboard.createAssignmentForOrder(order);
		//saveALLAssignments(allAssignments);
		//bookingService.updateOrderStatusToAssigned(order);
		return allAssignments;
	}


	
	
}
