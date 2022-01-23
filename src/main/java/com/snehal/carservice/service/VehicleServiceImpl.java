package com.snehal.carservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snehal.carservice.dao.VehicleRepository;
import com.snehal.carservice.model.Vehicle;
import com.snehal.carservice.cache.BootStrapCache;

@Service
public class VehicleServiceImpl implements VehicleService{
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	
	@Override
	public Vehicle saveVehicleInfo(Vehicle vehicle) {
		
		return vehicleRepository.save(vehicle);
	}

	
	@Override
	public List<Vehicle> getAllVehicles() {
		
		return vehicleRepository.findAll();
	}
/*
	@Override
	public List<VehicleRawData> saveAllVehicleRawData(List<VehicleRawData> vehicles) {
	return vehicleRawDataRepository.saveAll(vehicles);	
	}
	@Override
	public List<VehicleRawData> getAllVehicleRawData() {
	return vehicleRawDataRepository.findAll();	
	}
*/	
	@Override
	public void deleteAllVehicles() {
		 vehicleRepository.deleteAll();
	}
	
	@Override
	public List<Vehicle> saveVehicles(List<Vehicle> vehicles) {
		return vehicleRepository.saveAll(vehicles);
	}
	
	@PostConstruct
	public  void loadVehiclesCacheOnStartUp() {
		pouplateVehicleCache(getAllVehicles());
		System.out.println("Vehicle Loading on StartUp");
	}
	
	public void pouplateVehicleCache(List<Vehicle> allVehicles) {
		Map<Long,Vehicle> vehicleCache=BootStrapCache.getVehicleCache();
		vehicleCache.clear();
		
		for(Vehicle v:allVehicles) {

			vehicleCache.put(v.getVehicleId(), v);
		}
	}
	
	public void saveAllVehiclesForFirstTime() {
		deleteAllVehicles();
		VehicleManagement vehicleManagement=VehicleManagement.getVehicleManagement();
		List<Vehicle> vehicles=saveVehicles(new ArrayList(vehicleManagement.getVehicles()));
		pouplateVehicleCache(vehicles);
	}
}