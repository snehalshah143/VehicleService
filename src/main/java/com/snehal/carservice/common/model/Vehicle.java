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
	
	private String manufacturer;
	
	private String model;
	
	private VehicleSegment vehicleSegment;
	public Vehicle() {
		
	}
	public Vehicle(String manufacturer, String model, VehicleSegment vehicleSegment) {
		super();
		this.manufacturer = manufacturer;
		this.model = model;
		this.vehicleSegment = vehicleSegment;
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



	@Override
	public int hashCode() {
		return Objects.hash(manufacturer, model, vehicleSegment);
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
		return Objects.equals(manufacturer, other.manufacturer) && Objects.equals(model, other.model)
				&& vehicleSegment == other.vehicleSegment;
	}

	
	
}
