package com.snehal.carservice.admin.service;

import java.util.List;

import com.snehal.carservice.common.model.Vehicle;

public interface VehicleService {

	Vehicle saveVehicleInfo(Vehicle vehicle);

	List<Vehicle> getAllVehicles();

	List<VehicleRawData> saveAllVehicleRawData(List<VehicleRawData> vehicles);

	List<VehicleRawData> getAllVehicleRawData();

	void saveAllVehiclesForFirstTime();

	void deleteAllVehicles();

	List<Vehicle> saveVehicles(List<Vehicle> vehicles);

}
