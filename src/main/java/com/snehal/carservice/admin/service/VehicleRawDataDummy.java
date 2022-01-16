package com.snehal.carservice.admin.service;


public class VehicleRawDataDummy {

	/*
	@Id  
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="vehicle_raw_data_sequence_generator")
	@SequenceGenerator(name="vehicle_raw_data_sequence_generator" ,sequenceName = "vehicle_raw_data_seq")
	private Long vehicleRawDataId;
	*/
	
 private String createdAt;
 private String Category;
 
 private Integer Year;
 private String Model;
 
 private String Make;
 private String objectId;
 
 private String updatedAt;

public VehicleRawDataDummy(String createdAt, String category, Integer year, String model, String make, String objectId,
		String updatedAt) {
	super();
	this.createdAt = createdAt;
	this.Category = category;
	this.Year = year;
	this.Model = model;
	this.Make = make;
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
/*
public Long getVehicleRawDataId() {
	return vehicleRawDataId;
}

public void setVehicleRawDataId(Long vehicleRawDataId) {
	this.vehicleRawDataId = vehicleRawDataId;
}
*/
@Override
public String toString() {
	return "VehicleDetails [createdAt=" + createdAt + ", Category=" + Category + ", Year=" + Year + ", Model=" + Model
			+ ", Make=" + Make + ", objectId=" + objectId + ", updatedAt=" + updatedAt + "]";
}

}

