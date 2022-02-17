package com.snehal.carservice.mapper;

import com.snehal.carservice.model.domain.Vehicle;
import com.snehal.carservice.model.dto.VehicleJsonDto;
import com.snehal.carservice.model.persistable.VehiclePersistable;

public class VehicleMappers extends AbstarctMapper<VehicleJsonDto, Vehicle, VehiclePersistable> {

  private static VehicleMappers vehicleMappers = new VehicleMappers();

  public static VehicleMappers getVehicleMappers() {
    return vehicleMappers;
  }

  public VehicleJsonDto mapPersistableToJsonDto(VehiclePersistable persistable) {
    VehicleJsonDto jsonDto = new VehicleJsonDto();
    jsonDto.setVehicleId(persistable.getVehicleId());
    jsonDto.setVehicleSegment(persistable.getVehicleSegment());
    jsonDto.setModel(persistable.getModel());
    jsonDto.setManufacturer(persistable.getManufacturer());
    return jsonDto;
  }
}
