package com.snehal.carservice.model.domain;

import com.snehal.carservice.common.VehicleSegment;

public class Vehicle {

  private Long vehicleId;

  private String manufacturer;

  private String model;

  private VehicleSegment vehicleSegment;

  public Vehicle() {
    super();
  }

  public Long getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(Long vehicleId) {
    this.vehicleId = vehicleId;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public VehicleSegment getVehicleSegment() {
    return vehicleSegment;
  }

  public void setVehicleSegment(VehicleSegment vehicleSegment) {
    this.vehicleSegment = vehicleSegment;
  }
}
