package com.snehal.carservice.admin.service;

import java.io.Serializable;

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
 
 private Integer Year;
 private String Model;
 
 private String Make;
 private String objectId;
 
 private String updatedAt;

public VehicleRawData(String createdAt, String category, Integer year, String model, String make, String objectId,
		String updatedAt) {
	super();
	this.createdAt = createdAt;
	Category = category;
	Year = year;
	Model = model;
	Make = make;
	this.objectId = objectId;
	this.updatedAt = updatedAt;
}

public String getCreatedAt() {
	return createdAt;
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

public Integer getYear() {
	return Year;
}

public void setYear(Integer year) {
	Year = year;
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

public String getObjectId() {
	return objectId;
}

public void setObjectId(String objectId) {
	this.objectId = objectId;
}

public String getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(String updatedAt) {
	this.updatedAt = updatedAt;
}

@Override
public String toString() {
	return "VehicleDetails [createdAt=" + createdAt + ", Category=" + Category + ", Year=" + Year + ", Model=" + Model
			+ ", Make=" + Make + ", objectId=" + objectId + ", updatedAt=" + updatedAt + "]";
}

}

