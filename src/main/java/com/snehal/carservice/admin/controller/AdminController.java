package com.snehal.carservice.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snehal.carservice.admin.service.AssignmentService;
import com.snehal.carservice.admin.service.ProductService;
import com.snehal.carservice.admin.service.VehicleService;
import com.snehal.carservice.common.model.Order;
import com.snehal.carservice.user.service.BookingService;
@RestController
public class AdminController{

@Autowired
	private ProductService productService;

@Autowired
private VehicleService vehicleService;

@Autowired
private AssignmentService assignmentService;

@Autowired
private static BookingService bookingService;

@PostMapping(path = "/admin/saveproducts")
public void saveAllProductsForFirstTime() {
productService.saveAllProductsForFirstTime();
}

/*
 * @PostMapping(path = "/admin/saveVehicleRawData/{path}") public void
 * saveAllProductsForFirstTime(@PathVariable("path") String path) {
 * 
 * List<VehicleRawData> vehiclesRawDataList=new ArrayList<VehicleRawData>();
 * vehiclesRawDataList.addAll(VehicleRawDataLoading.loadVehicleRawData(path));
 * vehicleService.saveAllVehicleRawData(vehiclesRawDataList); }
 */

@PostMapping(path = "/admin/saveallvehicles")
public void saveAllVehiclesForFirstTime() {
	vehicleService.saveAllVehiclesForFirstTime();
}
//Night BatchProcessing
@PostMapping(path = "/admin/createallassigments")
public void saveAllAssigments() {
	List<Order> allorders=bookingService.getAllOrders();
	assignmentService.createAllAssigmentsForOrders(allorders);
	bookingService.updateOrderStatusToAssigned(allorders);
	
}
}