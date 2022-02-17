package com.snehal.carservice.model.persistable;

import com.snehal.carservice.common.ProductType;
import com.snehal.carservice.common.TimeSlot;
import com.snehal.carservice.common.VehicleSegment;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "product")
public class ProductPersistable extends AbstractPerstistable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence_generator")
  @SequenceGenerator(name = "product_sequence_generator", sequenceName = "product_seq")
  private Long productId;

  private @NotBlank ProductType productType;
  private @NotBlank VehicleSegment vehicleSegment;
  private @NotBlank TimeSlot timeSlot;
  private @NotBlank Double price;

  public ProductPersistable() {}

  public ProductPersistable(
      ProductType productType,
      VehicleSegment vehicleSegment,
      TimeSlot timeSlot,
      Double price,
      Date createdOn,
      String createdBy,
      String recordStatus) {

    this.productType = productType;
    this.vehicleSegment = vehicleSegment;
    this.timeSlot = timeSlot;
    this.price = price;
    this.setCreatedOn(createdOn);
    this.setCreatedBy(createdBy);
    this.setRecordStatus(recordStatus);
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

  @Override
  public int hashCode() {
    return Objects.hash(productType, timeSlot, vehicleSegment);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    ProductPersistable other = (ProductPersistable) obj;
    return productType == other.productType
        && timeSlot == other.timeSlot
        && vehicleSegment == other.vehicleSegment;
  }
}
