package com.snehal.carservice.service;

import java.util.List;

import com.snehal.carservice.model.persistable.VehiclePersistable;

public interface VehicleService {

	VehiclePersistable saveVehicleInfo(VehiclePersistable vehicle);

	List<VehiclePersistable> getAllVehicles();

//	List<VehicleRawData> saveAllVehicleRawData(List<VehicleRawData> vehicles);

//	List<VehicleRawData> getAllVehicleRawData();

	void saveAllVehiclesForFirstTime();

	void deleteAllVehicles();

	List<VehiclePersistable> saveVehicles(List<VehiclePersistable> vehicles);

}
