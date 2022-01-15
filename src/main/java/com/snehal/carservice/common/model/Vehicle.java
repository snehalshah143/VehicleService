package com.snehal.carservice.common.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable{

	@Id  
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="vehicle_sequence_generator")
	@SequenceGenerator(name="vehicle_sequence_generator" ,sequenceName = "vehicle_seq")
	private Long vehicleId;
	
	private String manufacturingCompany;
	
	private String modelNumber;
	
	private VehicleSegment vehicleSegment;

	public Vehicle(String manufacturingCompany, String modelNumber, VehicleSegment vehicleSegment) {
		super();
		this.manufacturingCompany = manufacturingCompany;
		this.modelNumber = modelNumber;
		this.vehicleSegment = vehicleSegment;
	}

	public String getManufacturingCompany() {
		return manufacturingCompany;
	}

	public void setManufacturingCompany(String manufacturingCompany) {
		this.manufacturingCompany = manufacturingCompany;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public VehicleSegment getVehicleSegment() {
		return vehicleSegment;
	}

	public void setVehicleSegment(VehicleSegment vehicleSegment) {
		this.vehicleSegment = vehicleSegment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(manufacturingCompany, modelNumber, vehicleSegment);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(manufacturingCompany, other.manufacturingCompany)
				&& Objects.equals(modelNumber, other.modelNumber) && vehicleSegment == other.vehicleSegment;
	}
	
	
}
