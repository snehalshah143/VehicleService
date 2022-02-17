package com.snehal.carservice.service;

import com.snehal.carservice.model.persistable.VehiclePersistable;
import java.util.List;

public interface VehicleService {

  VehiclePersistable saveVehicleInfo(VehiclePersistable vehicle);

  List<VehiclePersistable> getAllVehicles();

  //	List<VehicleRawData> saveAllVehicleRawData(List<VehicleRawData> vehicles);

  //	List<VehicleRawData> getAllVehicleRawData();

  void saveAllVehiclesForFirstTime();

  void deleteAllVehicles();

  List<VehiclePersistable> saveVehicles(List<VehiclePersistable> vehicles);

  VehiclePersistable getVehicle(Long vehicleId);
}
