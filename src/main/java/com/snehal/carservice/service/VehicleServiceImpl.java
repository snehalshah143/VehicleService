package com.snehal.carservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snehal.carservice.dao.VehicleRepository;
import com.snehal.carservice.model.persistable.VehiclePersistable;
import com.snehal.carservice.cache.BootStrapCache;

@Service
public class VehicleServiceImpl implements VehicleService{
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	
	@Override
	public VehiclePersistable saveVehicleInfo(VehiclePersistable vehicle) {
		
		return vehicleRepository.save(vehicle);
	}

	
	@Override
	public List<VehiclePersistable> getAllVehicles() {
		
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
	public List<VehiclePersistable> saveVehicles(List<VehiclePersistable> vehicles) {
		return vehicleRepository.saveAll(vehicles);
	}
	
	@PostConstruct
	public  void loadVehiclesCacheOnStartUp() {
		pouplateVehicleCache(getAllVehicles());
		System.out.println("Vehicle Loading on StartUp");
	}
	
	public void pouplateVehicleCache(List<VehiclePersistable> allVehicles) {
		Map<Long,VehiclePersistable> vehicleCache=BootStrapCache.getVehicleCache();
		vehicleCache.clear();
		
		for(VehiclePersistable v:allVehicles) {

			vehicleCache.put(v.getVehicleId(), v);
		}
	}
	
	public void saveAllVehiclesForFirstTime() {
		deleteAllVehicles();
		VehicleManagement vehicleManagement=VehicleManagement.getVehicleManagement();
		List<VehiclePersistable> vehicles=saveVehicles(new ArrayList(vehicleManagement.getVehicles()));
		pouplateVehicleCache(vehicles);
	}
}