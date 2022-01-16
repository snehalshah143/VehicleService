package com.snehal.carservice.admin.service;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "vehicle_raw_data")
public class VehicleRawData implements Serializable {

	
	@Id  
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="vehicle_raw_data_sequence_generator")
	@SequenceGenerator(name="vehicle_raw_data_sequence_generator" ,sequenceName = "vehicle_raw_data_seq")
	private Long vehicleRawDataId;
	
	
 private String createdAt;
 private String Category;
 
// private Integer Year;
 private String Model;
 
 private String Make;
// private String objectId;
 
// private String updatedAt;


public String getCreatedAt() {
	return createdAt;
}

public VehicleRawData(String createdAt, String category, String model, String make) {
	super();
	this.createdAt = createdAt;
	Category = category;
	Model = model;
	Make = make;
}

public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
}

public String getCategory() {
	return Category;
}

public void setCategory(String category) {
	Category = category;
}

public String getModel() {
	return Model;
}

public void setModel(String model) {
	Model = model;
}

public String getMake() {
	return Make;
}

public void setMake(String make) {
	Make = make;
}



public Long getVehicleRawDataId() {
	return vehicleRawDataId;
}

public void setVehicleRawDataId(Long vehicleRawDataId) {
	this.vehicleRawDataId = vehicleRawDataId;
}

@Override
public int hashCode() {
	return Objects.hash(Category, Make, Model);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	VehicleRawData other = (VehicleRawData) obj;
	return Objects.equals(Category, other.Category) && Objects.equals(Make, other.Make)
			&& Objects.equals(Model, other.Model);
}



}

