package com.snehal.carservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snehal.carservice.dao.AssignmentRepository;
import com.snehal.carservice.model.Assignment;
import com.snehal.carservice.model.Order;

@Service
public class AssignmentServiceImpl implements AssignmentService{

	
	@Autowired
	private AssignmentRepository assignmentRepository;
	
	
	public void saveALLAssignments(List<Assignment> assignments) {
		assignmentRepository.saveAll(assignments);
	}
	
	public void createAllAssigmentsForOrders(List<Order> orders) {
		
		List<Assignment> allAssignments=AssignmentDashboard.createAllAssignments(orders);
		saveALLAssignments(allAssignments);
	}
	
	
}
