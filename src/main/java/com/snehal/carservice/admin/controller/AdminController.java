package com.snehal.carservice.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snehal.carservice.admin.service.ProductService;
import com.snehal.carservice.admin.service.VehicleRawData;
import com.snehal.carservice.admin.service.VehicleRawDataLoading;
import com.snehal.carservice.admin.service.VehicleService;
@RestController
public class AdminController{

@Autowired
	private ProductService productService;

@Autowired
private VehicleService vehicleService;

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

}