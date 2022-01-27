package com.snehal.carservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snehal.carservice.cache.BootStrapCache;
import com.snehal.carservice.mapper.ProductMappers;
import com.snehal.carservice.mapper.VehicleMappers;
import com.snehal.carservice.model.dto.ProductJsonDto;
import com.snehal.carservice.model.dto.VehicleJsonDto;
import com.snehal.carservice.model.persistable.OrderPersistable;
import com.snehal.carservice.model.persistable.ProductPersistable;
import com.snehal.carservice.model.persistable.VehiclePersistable;
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
public ResponseEntity<List<ProductJsonDto>> getAllProducts(){
	
    List<ProductPersistable> products=productService.getAllProducts();
    List<ProductJsonDto> productsJsonDtoList=products.stream().map(p ->ProductMappers.getProductMappers().mapPersistableToJsonDto(p)).toList();

    return new ResponseEntity<List<ProductJsonDto>> (productsJsonDtoList,HttpStatus.OK);
}

@GetMapping(path = "/vehicles/getall")
public ResponseEntity<List<VehicleJsonDto>> getAllVehicles(){

    List<VehiclePersistable> vehicles=new ArrayList(BootStrapCache.getVehicleCache().values());
    List<VehicleJsonDto> vehicleJsonDtos=new ArrayList();
    for(VehiclePersistable v:vehicles) {
    	vehicleJsonDtos.add(VehicleMappers.getVehicleMappers().mapPersistableToJsonDto(v));
    }

    return new ResponseEntity<List<VehicleJsonDto>> (vehicleJsonDtos,HttpStatus.OK);
}

@GetMapping(path = "/vehicles/getallmake")
public ResponseEntity<Set<String>> getAllManufacturers(){

    List<VehiclePersistable> vehicles=new ArrayList(BootStrapCache.getVehicleCache().values());
    Set<String> manufacturers=vehicles.stream().map(v -> v.getManufacturer() ).collect(Collectors.toSet());
    return new ResponseEntity<Set<String>> (manufacturers,HttpStatus.OK);
}

@GetMapping(path = "/vehicles/getallmodels/{make}")
public ResponseEntity<Set<String>> getAllModelsForManufacturer(@PathVariable("make") String make){

    List<VehiclePersistable> vehicles=new ArrayList(BootStrapCache.getVehicleCache().values());
    Set<String> models=vehicles.stream().filter(v-> v.getManufacturer().equals(make)).map(v -> v.getModel() ).collect(Collectors.toSet());
    return new ResponseEntity<Set<String>> (models,HttpStatus.OK);
}

@PostMapping(path = "/admin/saveproducts")
public void saveAllProductsForFirstTime() {
productService.saveAllProductsForFirstTime();
}


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