package com.snehal.carservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snehal.carservice.model.persistable.OrderPersistable;
import com.snehal.carservice.model.persistable.ProductPersistable;
import com.snehal.carservice.service.AssignmentService;
import com.snehal.carservice.service.BookingService;
import com.snehal.carservice.service.ProductService;
import com.snehal.carservice.service.VehicleService;
@RestController
public class AdminController{

@Autowired
	private ProductService productService;

@Autowired
	private VehicleService vehicleService;

@Autowired
	private AssignmentService assignmentService;

@Autowired
	private BookingService bookingService;


@GetMapping(path = "/products/getall")
public ResponseEntity<List<ProductPersistable>> getAllProducts(){
	
    List<ProductPersistable> products=productService.getAllProducts();
    return new ResponseEntity<List<ProductPersistable>> (products,HttpStatus.OK);
}

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
public void createAllAssigments() {
	List<OrderPersistable> allorders=bookingService.getAllOrders();
	assignmentService.createAssigmentsAndUpdatedStatusForOrders(allorders);
	
}
}