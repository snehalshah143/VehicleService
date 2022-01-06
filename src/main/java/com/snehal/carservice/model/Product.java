package com.snehal.carservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "product")
public class Product {

	private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) long productId;
	 
	private @NotBlank ProductType productType;
	private @NotBlank VehicleSegment vehicleSegment;
	private @NotBlank TimeSlot timeSlot;
	
//working
/*    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", referencedColumnName = "orderId")
    @JsonIgnoreProperties("product")
    private Order order;*/


    public Product(){}

    
	public Product(ProductType productType, VehicleSegment vehicleSegment, TimeSlot timeSlot) {

		// this.productDetailId = productDetailId;
		this.productType = productType;
		this.vehicleSegment = vehicleSegment;
		this.timeSlot = timeSlot;

	}







	public long getProductId() {
		return productId;
	}


	public void setProductId(long productId) {
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




}
