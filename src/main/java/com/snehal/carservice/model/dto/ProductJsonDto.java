package com.snehal.carservice.model.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.snehal.carservice.common.ProductType;
import com.snehal.carservice.common.TimeSlot;
import com.snehal.carservice.common.VehicleSegment;

@JsonInclude(Include.NON_NULL)
public class ProductJsonDto implements Serializable {


 	private Long productId;


	private @NotBlank ProductType productType;
	private @NotBlank VehicleSegment vehicleSegment;
	private @NotBlank TimeSlot timeSlot;
	private @NotBlank Double price;
	
	
	public ProductJsonDto() {
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
