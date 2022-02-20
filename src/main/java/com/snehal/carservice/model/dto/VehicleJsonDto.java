package com.snehal.carservice.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.snehal.carservice.common.VehicleSegment;

@JsonInclude(Include.NON_NULL)
public class VehicleJsonDto extends AbstractJsonDto {

  private Long vehicleId;

  private String manufacturer;

  private String model;

  private VehicleSegment vehicleSegment;

  public VehicleJsonDto() {
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
