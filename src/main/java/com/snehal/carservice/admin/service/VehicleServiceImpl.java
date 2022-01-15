package com.snehal.carservice.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snehal.carservice.admin.dao.VehicleRepository;
import com.snehal.carservice.common.model.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService{
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private VehicleRawDataRepository vehicleRawDataRepository;
	
	@Override
	public Vehicle saveVehicleInfo(Vehicle vehicle) {
		
		return vehicleRepository.save(vehicle);
	}

	@Override
	public List<Vehicle> saveAllVehicleInfo(List<Vehicle> vehicles) {
		
		return vehicleRepository.saveAll(vehicles);
	}
	
	@Override
	public List<Vehicle> getAllVehicleInfo() {
		
		return vehicleRepository.findAll();
	}
	@Override
	public List<VehicleRawData> saveAllVehicleRawData(List<VehicleRawData> vehicles) {
	return vehicleRawDataRepository.saveAll(vehicles);	
	}
	@Override
	public List<VehicleRawData> getAllVehicleRawData() {
	return vehicleRawDataRepository.findAll();	
	}
	
}