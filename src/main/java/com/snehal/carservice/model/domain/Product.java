package com.snehal.carservice.model.domain;

import com.snehal.carservice.common.ProductType;
import com.snehal.carservice.common.TimeSlot;
import com.snehal.carservice.common.VehicleSegment;
import javax.validation.constraints.NotBlank;

public class Product {

  private Long productId;

  private @NotBlank ProductType productType;
  private @NotBlank VehicleSegment vehicleSegment;
  private @NotBlank TimeSlot timeSlot;
  private @NotBlank Double price;

  public Product() {
    super();
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public ProductType getProductType() {
    return productType;
  }

  public void setProductType(ProductType productType) {
    this.productType = productType;
  }

  public VehicleSegment getVehicleSegment() {
    return vehicleSegment;
  }

  public void setVehicleSegment(VehicleSegment vehicleSegment) {
    this.vehicleSegment = vehicleSegment;
  }

  public TimeSlot getTimeSlot() {
    return timeSlot;
  }

  public void setTimeSlot(TimeSlot timeSlot) {
    this.timeSlot = timeSlot;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
}
