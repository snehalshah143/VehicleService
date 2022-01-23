package com.snehal.carservice.model;

import java.io.Serializable;

public enum VehicleSegment implements Serializable{

	COMPACT(1,"HATCHBACK , COMPACT SEDAN",500),
	SEDAN_SUV(2,"SEDAN,SUV",600),
	LUXRY_CARS(3,"6SEATER,7SEATER,MERCEDES,AUDI,BMW",700),
	TWO_WHEELER(4,"TWO WHEELER,THREE WHEELER",300),
	LARGE_VEHICLE(5,"TRUCK,TEMPO",800);
	
	private double basePrice;
	private String value;
	private int id;
	VehicleSegment(int id,String value,double basePrice) {
		this.id=id;
	    this.value = value;
	    this.basePrice = basePrice;
	  }

	public String getVehicleSegment() {
	 return	this.name();
	}
	  public String getValue() {
	    return this.value;
	  }
	  public int getId() {
		    return this.id;
		  }
	  
	  public double getBasePrice() {
		    return this.basePrice;
		  }
}
